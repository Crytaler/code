package com.example.demo.controller;

import cn.hutool.core.convert.Convert;
import com.example.demo.entity.ZyjcUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName RedisController
 * @Descriptino
 * @Author myzhen
 * @Date 2020/12/19 下午3:17
 * @Version 1.0
 **/
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Autowired
    private ChannelTopic topic;

    @RequestMapping("/test")
    public String hello(){
        //redisTemplate.opsForValue().set("amadeus","mozart");
        //System.out.println(redisTemplate.opsForValue().get("amadeus"));

//        ZyjcUser user = new ZyjcUser();
//        int id =0;
//        user.setAge("27");
//        user.setUserName("马永振3");
//        user.setPassword("admin1");
//        user.setGender("男");
//        id =id++;
//        this.redisTemplate.opsForHash().put("hcp", UUID.randomUUID().toString(),user);
//        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        this.redisTemplate.opsForValue().set("hcp:",user);

//        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        Object hcp = redisTemplate.opsForValue().get("hcp");
//        ZyjcUser zyjcUser = Convert.convert(ZyjcUser.class, hcp);
//        System.out.println(zyjcUser);
//        System.out.println(zyjcUser.getUserName());
//        System.out.println(zyjcUser.getPassword());


//        List<Object> hcp = this.redisTemplate.opsForHash().values("hcp");
//        List<ZyjcUser> userInfo = hcp.stream().map(x -> {
//            return Convert.convert(ZyjcUser.class, x);
//        }).collect(Collectors.toList());
//        System.out.println(userInfo);
        Map<String, String> map = new HashMap<>();
        map.put("openId","232");
        map.put("userName","测试");
//        redisTemplate.convertAndSend(topic.getTopic(), map);

            System.out.println(map);
            redisTemplate.convertAndSend( topic.getTopic(), map);
//        Map<Object, Object> map = this.redisTemplate.opsForHash().entries("hcp");
//        for (Object o : map.keySet()) {
//            String s = Convert.toStr(o);
//            System.out.println(s);
//            Object o1 = map.get(o);
//            ZyjcUser convert = Convert.convert(ZyjcUser.class, o1);
//            System.out.println(convert);
//            this.redisTemplate.opsForHash().delete("hcp",s);
//            System.out.println("删除"+s+"成功");
//        }
        return "成功";
    }
}
