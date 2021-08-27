package com.kuang.parentcircle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 积分表
 * </p>
 *
 * @author madepeng
 * @since 2021-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("integral")
@ApiModel(value = "Integral对象", description = "积分表")
public class Integral implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "家长id")
    @TableField("partent_id")
    private Integer partentId;

    @ApiModelProperty(value = "积分数量")
    @TableField("number")
    private Integer number;

    @ApiModelProperty(value = "积分时间")
    @TableField("integral_time")
    private LocalDateTime integralTime;

    @ApiModelProperty(value = "积分原因")
    @TableField("reason")
    private String reason;

    @ApiModelProperty(value = "变动状态")
    @TableField("change_state")
    private String changeState;

    @ApiModelProperty(value = "变动类型")
    @TableField("change_type")
    private String changeType;

    @ApiModelProperty(value = "变动内容")
    @TableField("change_content")
    private String changeContent;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
