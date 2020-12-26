package com.example.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.poi.word.Word07Writer;
import com.example.demo.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;

/**
 * @ClassName LoginController
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/6/28 下午3:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("/pub")
public class LoginController {


        @PostMapping("/login")
        public String login(@RequestBody UserInfo user){
            String result;
            //1
            UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
            //2
            Subject subject = SecurityUtils.getSubject();
            try {
                //3
                subject.login(token);
                result = "成功";
            } catch (UnknownAccountException e){
                result = e.getMessage();
            }catch (IncorrectCredentialsException e){
                result = "密码错误";
            } catch (AuthenticationException e) {
                e.printStackTrace();
                result = "认证失败";

            }

            return result;
        }

    @PostMapping("/update")
    public String update(@RequestBody UserInfo user){


        return "result";
    }

    @PostMapping("/root")
    public String root(@RequestBody UserInfo user){


        return "root";
    }

    public static void main(String[] args) {
        String result = PinyinUtil.getFirstLetter("怡然","");
        System.out.println(result);


    }

    }

