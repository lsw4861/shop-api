package cn.duxue.api.shop.controller;

import cn.duxue.api.shop.entity.SysCaptchaEntity;
import cn.duxue.api.shop.service.SysCaptchaService;
import cn.duxue.common.utils.PageUtils;
import cn.duxue.common.utils.ResultUtils;
import cn.duxue.common.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 验证码表
 * Created by liang on 2019/1/5.
 */
@RestController
@RequestMapping("/captcha")
public class SysCaptchaController {

    @Autowired
    private SysCaptchaService sysCaptchaService;


    @ResponseBody
    @PostMapping("/list")
    public ResultVo list(@RequestBody SysCaptchaEntity sysCaptchaEntity){
        PageUtils pageUtils = sysCaptchaService.queryPage(sysCaptchaEntity);
        return ResultUtils.success(pageUtils);
    }


    @PostMapping( "/remove")
    @ResponseBody
    public ResultVo remove(@RequestBody Long[] ids){

        for(int i = 0; i < ids.length; i++){
            sysCaptchaService.removeById(ids[i]);
        }
        return ResultUtils.success();
    }

}
