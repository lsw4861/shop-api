package cn.duxue.common.enums;

import lombok.Getter;

/**
 * 结果状态
 * Created by liang on 2019/1/5.
 */
@Getter
public enum ResultCodeEnums {

    OK(200 , "成功"),
    ERROR(500, "失败");
    /**
     * ×´
     */
    private Integer code;

    /**
     * 状态码消息
     */
    private String msg;

    ResultCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

