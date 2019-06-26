package cn.duxue.api.shop.service;

import cn.duxue.api.shop.entity.SysTokenEntity;
import cn.duxue.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 认证Token表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-26 14:35:16
 */
public interface SysTokenService extends IService<SysTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 产生Token
     */
    Map<String, Object> createToken(Long sourceId);

    /**
     * 验证码token
     */
    boolean validate(Long studentId);

    /**
     * 退出
     */
    void logout(Long studentId);
}

