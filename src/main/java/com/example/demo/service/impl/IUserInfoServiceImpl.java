package com.example.demo.service.impl;

import com.example.demo.entity.UserInfo;
import com.example.demo.dao.UserInfoMapper;
import com.example.demo.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Service
public class IUserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
