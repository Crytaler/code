package com.example.demo.config;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class MsgListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println( "Message: " + message.toString() );
//        JSONObject jsonObject = JSONUtil.parseObj(message.toString());
//        System.out.println(jsonObject);
//        String openId = jsonObject.getStr("userName");
//        System.out.println(openId);
    }
}
