package com.example.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("zyjc_user")
@ApiModel(value="ZyjcUser对象", description="")
public class ZyjcUser implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
      @TableId("ID")
    private String id;

    @Excel(name = "用户名")
    @ApiModelProperty(value = "用户名")
    @TableField("user_name")
    private String userName;

    @Excel(name = "密码")
    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @Excel(name = "性别")
    @ApiModelProperty(value = "性别0:男 1:女")
    @TableField("gender")
    private String gender;

    @Excel(name = "年龄")
    @ApiModelProperty(value = "年龄")
    @TableField("age")
    private String age;

    @Excel(name = "创建时间")
    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    private String createTime;

    @Excel(name = "更新时间")
    @ApiModelProperty(value = "更新时间")
    @TableField("update_time")
    private String updateTime;


}
