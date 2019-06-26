package cn.duxue.api.shop.controller;


import cn.duxue.api.shop.entity.BShopOwnerEntity;
import cn.duxue.api.shop.entity.SysTokenEntity;
import cn.duxue.api.shop.form.SysLoginForm;
import cn.duxue.api.shop.service.BShopOwnerService;
import cn.duxue.api.shop.service.SysCaptchaService;
import cn.duxue.api.shop.service.SysTokenService;
import cn.duxue.common.annotation.Login;
import cn.duxue.common.annotation.LoginUser;
import cn.duxue.common.utils.ResultUtils;
import cn.duxue.common.vo.ResultVo;
import com.baomidou.mybatisplus.core.toolkit.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;


/**
 * 商家用户
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2019-06-26 14:35:16
 */
@RestController
public class BShopOwnerController {
    @Autowired
    private BShopOwnerService studentService;

    @Autowired
    private SysCaptchaService studentCaptchaService;


    @Autowired
    private SysTokenService studentTokenService;

    /**
     * 验证码
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = studentCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 学生登录
     */
    @PostMapping("login")
    public ResultVo login(@RequestBody SysLoginForm form) {
        boolean captcha = studentCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if(!captcha){
            return ResultUtils.error(500, "验证码不正确");
        }

        Map<String, Object> map = studentService.login(form.getUsername(), form.getPassword());

        return ResultUtils.success(map);
    }

    /**
     * 退出
     */
    @Login
    @PostMapping("logout")
    public ResultVo logout(@LoginUser BShopOwnerEntity shopOwnerEntity) {
        System.err.println(shopOwnerEntity);
        studentTokenService.logout(shopOwnerEntity.getShopOwnerId());
        return ResultUtils.success();
    }



}
