package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.PermissionMapper;
import com.example.demo.dao.RoleMapper;
import com.example.demo.dao.UserInfoMapper;
import com.example.demo.dao.UserPermissionMapper;
import com.example.demo.entity.Permission;
import com.example.demo.entity.UserInfo;
import com.example.demo.entity.UserPermission;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName UserInfoServiceImpl
 * @Descriptino TODO
 * @Author myzhen
 * @Date 2020/6/28 下午2:43
 * @Version 1.0
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

        @Autowired
        private UserInfoMapper userInfoMapper;

        @Autowired
        private RoleMapper roleMapper;

        @Autowired
        private PermissionMapper permissionMapper;

        @Autowired
        private UserPermissionMapper userPermissionMapper;

        @Override
        public UserInfo findUserInfoByLoginName(String loginName) {
            return userInfoMapper.selectUserInfoByLoginName(loginName);
        }

        @Override
        public UserInfo findUserAllInfoByUserId(UserInfo userInfo) {
            QueryWrapper<UserPermission> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(UserPermission::getUserId,userInfo.getUserId());
            List<UserPermission> userPermissions = userPermissionMapper.selectList(wrapper);
            List<Integer> collect = userPermissions.stream().map(UserPermission::getPmsId).collect(Collectors.toList());

            QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().in(Permission::getPmsId,collect);
            List<Permission> permissions = permissionMapper.selectList(queryWrapper);
            userInfo.setRoleList(roleMapper.selectRolesByUserId(userInfo.getUserId()));
            userInfo.setPermissionList(permissions);
            return userInfo;
        }
    }

