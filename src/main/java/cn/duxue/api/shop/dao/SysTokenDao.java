package cn.duxue.api.shop.dao;

import cn.duxue.api.shop.entity.SysTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 认证Token表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-26 14:35:16
 */
@Mapper
public interface SysTokenDao extends BaseMapper<SysTokenEntity> {
	
}
