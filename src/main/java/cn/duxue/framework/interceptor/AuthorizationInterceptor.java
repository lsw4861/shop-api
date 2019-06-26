package cn.duxue.framework.interceptor;

import cn.duxue.api.shop.entity.SysTokenEntity;
import cn.duxue.api.shop.service.SysTokenService;
import cn.duxue.common.annotation.Login;
import cn.duxue.common.enums.ExceptionCodeEnums;
import cn.duxue.common.exception.DuXueException;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 * Created by liang on 2019/1/5.
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SysTokenService sysTokenService;

    public static final String WECHAT_KEY = "shopOwnerId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //获取用户凭证
        String token = request.getHeader("token");
        if(StrUtil.isBlank(token)){
            token = request.getParameter("token");
        }

        //token不能为空
        if(StrUtil.isBlank(token)){
            throw new DuXueException(ExceptionCodeEnums.TOKEN_ISNOT_BLANK_ERROR);
        }

        QueryWrapper<SysTokenEntity> sysTokenEntityQueryWrapper = new QueryWrapper<>();
        sysTokenEntityQueryWrapper.eq("token", token);
        SysTokenEntity sysTokenEntity = sysTokenService.getOne(sysTokenEntityQueryWrapper);


        //请先登录系统
        if(sysTokenEntity == null){
            throw new DuXueException(ExceptionCodeEnums.STUDENT_LOGIN_ERROR);
        }


        //token失效，请重新登录
        if(!sysTokenService.validate(sysTokenEntity.getSourceId())){
            throw new DuXueException(ExceptionCodeEnums.TOKEN_IS_INVALID_ERROR);
        }

        //设置wechatId到request里，后续根据uwechatId，获取用户信息
        request.setAttribute(WECHAT_KEY, sysTokenEntity.getSourceId());

        return true;
    }
}
