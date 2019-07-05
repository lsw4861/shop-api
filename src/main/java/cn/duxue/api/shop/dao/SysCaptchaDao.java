package cn.duxue.api.shop.dao;

import cn.duxue.api.shop.entity.SysCaptchaEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 验证码表
 * Created by liang on 2019/1/5.
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {


    Page<Map<String, Object>> selectSysCaptcha(@Param("page") Page page,  @Param("sysCaptchaEntity") SysCaptchaEntity sysCaptchaEntity);


}
