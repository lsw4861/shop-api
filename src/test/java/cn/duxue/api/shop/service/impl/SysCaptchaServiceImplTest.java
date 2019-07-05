package cn.duxue.api.shop.service.impl;

import cn.duxue.api.shop.dao.SysCaptchaDao;
import cn.duxue.api.shop.entity.SysCaptchaEntity;
import cn.duxue.api.shop.service.SysCaptchaService;
import cn.duxue.common.utils.PageUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;


/**
 * created by liang on 2019/7/4 .
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SysCaptchaServiceImplTest {

    @Autowired
    private SysCaptchaService sysCaptchaService;

    @Autowired
    private SysCaptchaDao sysCaptchaDao;

    @Test
    public void queryPage() {

        SysCaptchaEntity sysCaptchaEntity = new SysCaptchaEntity();

        Map<String, Object> params = new HashMap<>();
        params.put("currPage", 1);
        params.put("pageSize", 10);
        sysCaptchaEntity.setParams(params);

        PageUtils pageInfo  = sysCaptchaService.queryPage(sysCaptchaEntity);
        System.err.println(pageInfo);


    }
}