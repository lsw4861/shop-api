package cn.duxue.api.shop.service;

import cn.duxue.api.shop.entity.SysCaptchaEntity;
import cn.duxue.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * 验证码表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-26 14:35:16
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    PageUtils queryPage(Map<String, Object> params);


    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     */
    boolean validate(String uuid, String code);
}

