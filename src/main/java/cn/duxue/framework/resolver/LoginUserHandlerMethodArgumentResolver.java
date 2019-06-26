package cn.duxue.framework.resolver;

import cn.duxue.api.shop.entity.BShopOwnerEntity;
import cn.duxue.api.shop.service.BShopOwnerService;
import cn.duxue.common.annotation.LoginUser;
import cn.duxue.framework.interceptor.AuthorizationInterceptor;
import cn.hutool.core.convert.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 * Created by liang on 2019/1/5.
 */
@Component
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private BShopOwnerService shopOwnerService;


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(BShopOwnerEntity.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory)  {
        //获取用户ID
        Object object = request.getAttribute(AuthorizationInterceptor.WECHAT_KEY, RequestAttributes.SCOPE_REQUEST);
        if(object == null){
            return null;
        }

        //获取用户信息
        BShopOwnerEntity shopOwnerEntity = shopOwnerService.getById(Convert.toLong(object));

        return shopOwnerEntity;
    }
}
