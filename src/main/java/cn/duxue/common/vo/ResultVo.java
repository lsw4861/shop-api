package cn.duxue.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回给前端的数据封装
 * Created by liang on 2019/1/5.
 */
@Data
public class ResultVo<T> implements Serializable {
    private static final long serialVersionUID = -4414926978700453869L;

    /**
     * 状态马
     */
    private Integer code;

    /**
     * 状态说明
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

}