//package com.example.demo.common.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
///**
// * @ClassName RedisConfig
// * @Descriptino TODO
// * @Author myzhen
// * @Date 2020/12/19 下午3:16
// * @Version 1.0
// **/
//@Configuration
//public class RedisConfig {
//
//    @Bean
//    public RedisTemplate<String, Object>redisTemplate(RedisConnectionFactory factory){
//        RedisTemplate<String,Object>template=new RedisTemplate<>();
//
//        template.setConnectionFactory(factory);
//
//        template.setKeySerializer(new StringRedisSerializer());
//
//        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
//
//        return template;
//    }
//}
