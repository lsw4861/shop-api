package cn.duxue.api.shop.form;

import cn.hutool.crypto.SecureUtil;
import lombok.Data;

/**
 * 登录表单
 * Created by liang on 2019/1/5.
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;

    public static void main(String[] args) {
        System.err.println(SecureUtil.md5("123456"));
    }

}
