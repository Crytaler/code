package com.example.demo.service;

import com.example.demo.entity.UserInfo;

/**
 * @ClassName UserInfoService
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/6/28 下午2:43
 * @Version 1.0
 **/
public interface UserInfoService {



    /**
     * 查询用户的基本信息，不包括角色、权限信息
     * @param loginName
     * @return
     */
    UserInfo findUserInfoByLoginName(String loginName);

    /**
     * 查询用户的信息，包括角色、权限信息
     * @param userInfo
     * @return
     */
    UserInfo findUserAllInfoByUserId(UserInfo userInfo);

}
