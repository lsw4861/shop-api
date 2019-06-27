package cn.duxue.api.shop.service.impl;

import cn.duxue.api.shop.dao.SysCaptchaDao;
import cn.duxue.api.shop.entity.SysCaptchaEntity;
import cn.duxue.api.shop.service.SysCaptchaService;
import cn.duxue.common.enums.ExceptionCodeEnums;
import cn.duxue.common.exception.DuXueException;
import cn.duxue.common.utils.PageUtils;
import cn.duxue.common.utils.ValidateCodeUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Map;

@Service("sysCaptchaService")
public class SysCaptchaServiceImpl extends ServiceImpl<SysCaptchaDao, SysCaptchaEntity> implements SysCaptchaService {

    @Autowired
    private Producer producer;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }



    @Override
    public BufferedImage getCaptcha(String uuid) {
        if(StrUtil.isBlank(uuid)){
            throw new DuXueException(ExceptionCodeEnums.UUID_IS_NOT_BLANK_ERROR);
        }
        //生成文字验证码
//        String code = producer.createText();

        //自定义验证码
        ValidateCodeUtil validateCodeUtil = new ValidateCodeUtil(94,42,4,50);
        String code = validateCodeUtil.getCode();
        BufferedImage buffImg = validateCodeUtil.getBuffImg();

        SysCaptchaEntity sysCaptchaEntity = new SysCaptchaEntity();
        sysCaptchaEntity.setUuid(uuid);
        sysCaptchaEntity.setCode(code);
        //5分钟后过期
        sysCaptchaEntity.setExpireTime(DateUtil.offset(new Date(), DateField.MINUTE, 5));
        this.save(sysCaptchaEntity);

//        return producer.createImage(code);
        return buffImg;
    }

    @Override
    public boolean validate(String uuid, String code) {
        SysCaptchaEntity sysCaptchaEntity = this.getOne(new QueryWrapper<SysCaptchaEntity>().eq("uuid", uuid));
        if(sysCaptchaEntity == null){
            return false;
        }

        //删除验证码
        this.removeById(uuid);

        if(sysCaptchaEntity.getCode().equalsIgnoreCase(code) && sysCaptchaEntity.getExpireTime().getTime() >= System.currentTimeMillis()){
            return true;
        }

        return false;
    }

}
