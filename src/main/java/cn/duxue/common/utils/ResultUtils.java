package cn.duxue.common.utils;

import cn.duxue.common.enums.ResultCodeEnums;
import cn.duxue.common.vo.ResultVo;

/**
 * 结果集封装
 * Created by liang on 2019/1/5.
 */
public class ResultUtils {
    public static ResultVo success(Object data){
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(ResultCodeEnums.OK.getCode());
        resultVO.setData(data);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code , String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }

    public static ResultVo error(ResultCodeEnums resultCodeEnums) {
        ResultVo resultVO = new ResultVo();
        resultVO.setMsg(resultCodeEnums.getMsg());
        resultVO.setCode(resultCodeEnums.getCode());
        return resultVO;
    }
}
