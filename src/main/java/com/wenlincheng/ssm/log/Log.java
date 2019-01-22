package com.wenlincheng.ssm.log;


import java.lang.annotation.*;

/**
 * @ClassName: Log
 * @Description: TODO
 * @Author: Cheng
 * @Date: 2018/11/10 22:23
 * @Version: 1.0.0
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {

    /**方法描述*/
    String  methodDesc() default "";

}
