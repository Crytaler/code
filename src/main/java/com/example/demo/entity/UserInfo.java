package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_info")
@ApiModel(value="UserInfo对象", description="用户表")
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty(value = "登录名")
    @TableField("login_name")
    private String loginName;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "状态 1为锁定 0为正常，默认为0")
    @TableField("status")
    private Integer status;

    @TableField(exist = false)
    private List<Role> roleList;

    @TableField(exist = false)
    private List<Permission> permissionList;

    @TableField(exist = false)
    private String type;

    @TableField(exist = false)
    private String column;
    @TableField(exist = false)
    private String  relation;
    @TableField(exist = false)
    private String condition;

    @TableField(exist = false)
    private Integer role_id;

    @TableField(exist = false)
    private Integer isTransfer;


}
