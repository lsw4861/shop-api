package cn.duxue.api.shop.dao;

import cn.duxue.api.shop.entity.SysTokenEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 认证Token表
 * Created by liang on 2019/1/5.
 */
@Mapper
public interface SysTokenDao extends BaseMapper<SysTokenEntity> {
	
}
