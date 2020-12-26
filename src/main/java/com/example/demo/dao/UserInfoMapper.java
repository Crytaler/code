package com.example.demo.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.SearchCondion;
import com.example.demo.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Mapper
@Repository
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    UserInfo selectUserInfoByLoginName(@Param("loginName") String loginName);


    Page<UserInfo> selectUserInfo(Page<Map<String, Object>> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
