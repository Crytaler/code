package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MultiRedisController
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2021/1/25 下午9:42
 * @Version 1.0
 **/
@RestController
@RequestMapping("/multipleRedisTest")
public class MultiRedisController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisTemplate redisTemplate;
    //需要根据名称来注入
    @Resource(name = "secondRedisTemplate")
    private RedisTemplate secondRedisTemplate;


    @RequestMapping("/redis")
    public Object redis(){
        //logger.info("id={},name={},start...",Thread.currentThread().getId(),Thread.currentThread().getName());
        JSONObject result = new JSONObject();

        UserInfo userEntity = new UserInfo();
        userEntity.setUserId(1);
        userEntity.setUserName("张三");

        UserInfo userEntity1 = new UserInfo();
        userEntity1.setUserId(1);
        userEntity1.setUserName("里斯本");

        //演示将bean对象转换为json字符串再存入redis, start...
        String entityStr = JSONObject.toJSONString(userEntity);
        String entityStr1 = JSONObject.toJSONString(userEntity1);
        logger.info("即将存入缓存的字符串={}",entityStr);
        redisTemplate.opsForValue().set("userEntityStr", entityStr, 5, TimeUnit.MINUTES);
        secondRedisTemplate.opsForValue().set("userEntityStr", entityStr1, 5, TimeUnit.MINUTES);
        //演示将bean对象转换为json字符串再存入redis, end.
//
        UserInfo userEntityFromStr = null;
        UserInfo userEntityFromStr2 = null;
        String restr1 =(String)redisTemplate.opsForValue().get("userEntityStr");
        logger.info("1.1缓存取出的字符串={}",restr1);
        userEntityFromStr = JSONObject.parseObject(restr1, UserInfo.class);
        logger.info("1.2转换为对象userEntity={}",userEntityFromStr);

        String restr2 =(String)secondRedisTemplate.opsForValue().get("userEntityStr");
        logger.info("2.1缓存取出的字符串={}",restr2);
        userEntityFromStr2 = JSONObject.parseObject(restr2, UserInfo.class);
        logger.info("2.2转换为对象userEntity={}",userEntityFromStr2);

        result.put("code", 200);
        return result;
    }

}
