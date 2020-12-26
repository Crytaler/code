package com.example.demo.dao;

import com.example.demo.entity.UserPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户-权限关联表 Mapper 接口
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Mapper
@Repository
public interface UserPermissionMapper extends BaseMapper<UserPermission> {

}
