package com.example.demo.dao;

import com.example.demo.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Mapper
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

}
