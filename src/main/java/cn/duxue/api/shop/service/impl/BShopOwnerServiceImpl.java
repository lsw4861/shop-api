package cn.duxue.api.shop.service.impl;

import cn.duxue.api.shop.dao.BShopOwnerDao;
import cn.duxue.api.shop.entity.BShopOwnerEntity;
import cn.duxue.api.shop.service.BShopOwnerService;
import cn.duxue.api.shop.service.SysTokenService;
import cn.duxue.common.enums.ExceptionCodeEnums;
import cn.duxue.common.exception.DuXueException;
import cn.duxue.common.utils.PageUtils;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;


@Service("bShopOwnerService")
public class BShopOwnerServiceImpl extends ServiceImpl<BShopOwnerDao, BShopOwnerEntity> implements BShopOwnerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        return null;
    }

    @Autowired
    private SysTokenService studentTokenService;

    @Override
    @Transactional
    public Map<String, Object> login(String loginName, String password) {

        //判断用户名或者密码不能为空
        if(StrUtil.isBlank(loginName) || StrUtil.isBlank(password)){
            throw  new DuXueException(ExceptionCodeEnums.USERPWD_ISNOT_BLANK);
        }

        //根据用户名和密码查询
        QueryWrapper<BShopOwnerEntity> studentQueryWrapper = new QueryWrapper<BShopOwnerEntity>();
        studentQueryWrapper.eq("login_name", loginName).eq("password", SecureUtil.md5(password));
        BShopOwnerEntity shopOwnerEntity = baseMapper.selectOne(studentQueryWrapper);

        if(shopOwnerEntity == null){
            throw  new DuXueException(ExceptionCodeEnums.USERPWD_ISNOT_MATCH);
        }

        //账号锁定
        if(shopOwnerEntity.getStatus().equals("2")){
            throw  new  DuXueException(ExceptionCodeEnums.STUDENT_STATUS_DISABLE_ERROR);
        }

        //生成token
        Map<String, Object> token = studentTokenService.createToken(shopOwnerEntity.getShopOwnerId());

        return  token;
    }

    @Override
    public BShopOwnerEntity queryByShopOwnerName(String shopOwnerName) {
        QueryWrapper<BShopOwnerEntity> shopOwnerEntityQueryWrapper = new QueryWrapper<>();
        shopOwnerEntityQueryWrapper.eq("shop_owner_name", shopOwnerName);
        return  baseMapper.selectOne(shopOwnerEntityQueryWrapper);
    }


}
