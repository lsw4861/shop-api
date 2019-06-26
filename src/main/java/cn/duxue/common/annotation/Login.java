package cn.duxue.common.annotation;

import java.lang.annotation.*;

/**
 * 登录效验
 * Created by liang on 2019/1/5.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
