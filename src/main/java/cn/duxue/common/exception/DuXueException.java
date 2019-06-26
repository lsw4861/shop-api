package cn.duxue.common.exception;

import cn.duxue.common.enums.ExceptionCodeEnums;
import lombok.Getter;

/**
 * 全局异常定义
 * Created by liang on 2019/1/5.
 */
@Getter
public class DuXueException extends RuntimeException {
    /**
     *  ，状态码
     */
    private Integer code;

    public DuXueException(ExceptionCodeEnums exceptionCodeEnums) {
        super(exceptionCodeEnums.getMsg());
        this.code = exceptionCodeEnums.getCode();
    }

    public DuXueException(ExceptionCodeEnums exceptionCodeEnums , String msg) {
        super(msg);
        this.code = exceptionCodeEnums.getCode();
    }


}
