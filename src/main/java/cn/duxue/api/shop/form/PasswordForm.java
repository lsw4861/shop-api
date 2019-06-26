package cn.duxue.api.shop.form;

import lombok.Data;

/**
 * 密码表单
 * Created by liang on 2019/1/5.
 */
@Data
public class PasswordForm {
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

}
