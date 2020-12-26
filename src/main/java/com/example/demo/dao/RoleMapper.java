package com.example.demo.dao;

import com.example.demo.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> selectRolesByUserId(@Param("userId") Integer userId);
}
