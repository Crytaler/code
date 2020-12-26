package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @ClassName record
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/12/17 下午9:32
 * @Version 1.0
 **/
@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD ,ElementType.TYPE_USE,ElementType.ANNOTATION_TYPE,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Record {

    String operate() default "";
    String name() default "";
}
