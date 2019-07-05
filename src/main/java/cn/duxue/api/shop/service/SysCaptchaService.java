package cn.duxue.api.shop.service;

import cn.duxue.api.shop.entity.SysCaptchaEntity;
import cn.duxue.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * 验证码表
 * Created by liang on 2019/1/5.
 */
public interface SysCaptchaService extends IService<SysCaptchaEntity> {

    PageUtils queryPage(SysCaptchaEntity sysCaptchaEntity);


    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     */
    boolean validate(String uuid, String code);
}

