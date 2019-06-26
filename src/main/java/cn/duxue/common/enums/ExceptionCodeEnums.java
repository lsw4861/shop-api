package cn.duxue.common.enums;

import lombok.Getter;

/**
 * 异常状态
 * created by liang on 2019/1/5 .
 */
@Getter
public enum ExceptionCodeEnums {

    PARAM_ERROR(400 , "参数格式不正确"),

    UUID_IS_NOT_BLANK_ERROR(500 , "uuid不能为空"),

    STUDENT_LOGIN_ERROR(500 , "请先登录系统"),

    TOKEN_ISNOT_BLANK_ERROR(401 , "token不能为空"),

    TOKEN_IS_INVALID_ERROR(401 , "token失效，请重新登录"),

    STUDENT_STATUS_DISABLE_ERROR(500,"账号已被锁定,请联系管理员"),

    USERPWD_ISNOT_BLANK(401 , "账号名称或密码不能为空"),

    USERPWD_ISNOT_MATCH(401 , "账号名称或密码不正确"),

    USER_IS_DISABLE(403 , "账号已被禁用"),

    USER_IS_EXIST(400 , "账号已存在"),

    STUDENT_IS_NOT_GRADES(500 , "请联系运营老师，分配相应的班级！"),

    ;

    private Integer code;

    private String msg;

    ExceptionCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

