package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户-权限关联表
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user_permission")
@ApiModel(value="UserPermission对象", description="用户-权限关联表")
public class UserPermission implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty(value = "权限id")
    @TableField("pms_id")
    private Integer pmsId;


}
