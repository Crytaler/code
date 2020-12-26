package com.example.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @ClassName RecordAspect
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/12/17 下午9:34
 * @Version 1.0
 **/
@Aspect
@Configuration
public class RecordAspect {

    //定义切点方法
    @Pointcut("@annotation(com.example.demo.annotation.Record)")
    public  void pointCut(){}

    //环绕通知
    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) {
        try{
            //1.获取到所有的参数值的数组
            Object[] args = joinPoint.getArgs();
            Signature signature = joinPoint.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            //2.获取到方法的所有参数名称的字符串数组
            String[] parameterNames = methodSignature.getParameterNames();
            Method method = methodSignature.getMethod();
            System.out.println("---------------参数列表开始-------------------------");
            for (int i =0 ,len=parameterNames.length;i < len ;i++){
                System.out.println("参数名："+ parameterNames[i] + " = " +args[i]);
            }
            System.out.println("---------------参数列表结束-------------------------");
            Record redis=(Record)method.getAnnotation(Record.class);
            System.out.println("自定义注解 key:" + redis.name());
            System.out.println("自定义注解 keyField:" + redis.operate());
            Class cla=method.getClass();
            if(cla.isAnnotationPresent(Record.class)){
                Record redisHandel =(Record)cla.getAnnotation(Record.class);
                String key=redisHandel.operate();
                String keyField=redisHandel.name();
                System.out.println("key = " + key);
                System.out.println("keyField = " + keyField);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
