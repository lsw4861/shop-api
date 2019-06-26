package cn.duxue.api.shop.dao;

import cn.duxue.api.shop.entity.SysCaptchaEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 验证码表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-26 14:35:16
 */
@Mapper
public interface SysCaptchaDao extends BaseMapper<SysCaptchaEntity> {
	
}
