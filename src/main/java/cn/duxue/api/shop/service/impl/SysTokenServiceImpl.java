package cn.duxue.api.shop.service.impl;

import cn.duxue.api.shop.dao.SysTokenDao;
import cn.duxue.api.shop.entity.SysTokenEntity;
import cn.duxue.api.shop.service.SysTokenService;
import cn.duxue.common.utils.PageUtils;
import cn.duxue.common.utils.TokenGeneratorUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service("sysTokenService")
public class SysTokenServiceImpl extends ServiceImpl<SysTokenDao, SysTokenEntity> implements SysTokenService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }
    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Override
    public Map<String, Object> createToken(Long sourceId) {

        //生成一个token
        String token = TokenGeneratorUtils.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token

        QueryWrapper<SysTokenEntity> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("source_id", sourceId);
        SysTokenEntity sysTokenEntity = baseMapper.selectOne(studentQueryWrapper);

        if(sysTokenEntity == null){
            sysTokenEntity = new SysTokenEntity();
            sysTokenEntity.setSourceId(sourceId);
            sysTokenEntity.setToken(token);
            sysTokenEntity.setUpdateTime(now);
            sysTokenEntity.setExpireTime(expireTime);

            //保存token
            this.save(sysTokenEntity);
        }else{
            sysTokenEntity.setToken(token);
            sysTokenEntity.setUpdateTime(now);
            sysTokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(sysTokenEntity);
        }
        HashMap<String, Object> map = new HashMap<>();

        map.put("token", token);
        map.put("expire", EXPIRE);

        return map;

    }

    @Override
    public boolean validate(Long sourceId) {
        SysTokenEntity sysTokenEntity = this.getOne(new QueryWrapper<SysTokenEntity>().eq("source_id", sourceId));
        if(sysTokenEntity == null){
            return false;
        }

        if(sysTokenEntity.getExpireTime().getTime() >= System.currentTimeMillis()){
            return true;
        }

        return false;
    }

    @Override
    public void logout(Long sourceId) {

        SysTokenEntity sysTokenEntity = this.getOne(new QueryWrapper<SysTokenEntity>().eq("source_id", sourceId));

        //生成一个token
        String token = TokenGeneratorUtils.generateValue();

        //修改token
        sysTokenEntity.setToken(token);
        this.updateById(sysTokenEntity);
    }

}
