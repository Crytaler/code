package com.example.demo.service.impl;

import com.example.demo.entity.Permission;
import com.example.demo.dao.PermissionMapper;
import com.example.demo.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Service
public class IPermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
