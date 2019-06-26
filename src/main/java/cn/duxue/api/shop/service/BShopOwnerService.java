package cn.duxue.api.shop.service;

import cn.duxue.api.shop.entity.BShopOwnerEntity;
import cn.duxue.common.utils.PageUtils;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 商家用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-26 14:35:16
 */
public interface BShopOwnerService extends IService<BShopOwnerEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 学生登陆
     */
    Map<String, Object> login(String loginName, String password);


    /**
     * 根据姓名查询
     * @param shopOwnerName
     * @return
     */
    BShopOwnerEntity queryByShopOwnerName(String shopOwnerName);
}

