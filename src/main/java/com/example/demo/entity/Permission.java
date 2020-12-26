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
 * 权限表
 * </p>
 *
 * @author yongzhen
 * @since 2020-06-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("permission")
@ApiModel(value="Permission对象", description="权限表")
public class Permission implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "pms_id", type = IdType.AUTO)
    private Integer pmsId;

    @ApiModelProperty(value = "接口路径")
    @TableField("url")
    private String url;

    @ApiModelProperty(value = "权限说明")
    @TableField("description")
    private String description;

    @ApiModelProperty(value = "权限名称")
    @TableField("pms_name")
    private String pmsName;


}
