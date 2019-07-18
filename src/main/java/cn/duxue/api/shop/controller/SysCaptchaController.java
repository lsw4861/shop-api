package cn.duxue.api.shop.controller;

import cn.duxue.api.shop.entity.SysCaptchaEntity;
import cn.duxue.api.shop.service.SysCaptchaService;
import cn.duxue.common.utils.PageUtils;
import cn.duxue.common.utils.ResultUtils;
import cn.duxue.common.vo.ResultVo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

    @ResponseBody
    @PostMapping("/add")
    public ResultVo add(@RequestBody SysCaptchaEntity sysCaptchaEntity){
        boolean save = sysCaptchaService.save(sysCaptchaEntity);
        return ResultUtils.success(save);
    }

    @ResponseBody
    @GetMapping("/edit/{id}")
    public ResultVo edit(@PathVariable("id") long id){
        SysCaptchaEntity sysCaptchaEntity = sysCaptchaService.getById(id);
        return ResultUtils.success(sysCaptchaEntity);
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
