package com.example.demo.service.impl;

import com.example.demo.entity.UserPermission;
import com.example.demo.dao.UserPermissionMapper;
import com.example.demo.service.IUserPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-权限关联表 服务实现类
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Service
public class IUserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements IUserPermissionService {

}
