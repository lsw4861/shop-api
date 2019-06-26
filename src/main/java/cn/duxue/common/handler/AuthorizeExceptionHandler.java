package cn.duxue.common.handler;

import cn.duxue.common.enums.ExceptionCodeEnums;
import cn.duxue.common.enums.ResultCodeEnums;
import cn.duxue.common.utils.ResultUtils;
import cn.duxue.common.vo.ResultVo;
import cn.duxue.common.exception.DuXueException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 异常统一处理类
 * Created by liang on 2019/1/5.
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class AuthorizeExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultVo exceptionHandler(Exception e) {

        // 参数校验异常
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            List<ObjectError> errors = ex.getBindingResult().getAllErrors();
            ObjectError error= errors.get(0);
            ResultVo resultVO = ResultUtils.error(ExceptionCodeEnums.PARAM_ERROR.getCode(), error.getDefaultMessage());
            return resultVO;

         // 自定义异常
        }else if (e instanceof DuXueException) {
            DuXueException ex = (DuXueException) e;
            log.error(ex.getMessage());
            return ResultUtils.error(ex.getCode() , ex.getMessage());
        }
        return ResultUtils.error(ResultCodeEnums.ERROR);
    }
}


