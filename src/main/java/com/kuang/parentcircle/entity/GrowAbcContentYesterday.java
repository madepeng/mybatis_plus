package com.kuang.parentcircle.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 总览_学习指导表
 * </p>
 *
 * @author madepeng
 * @since 2021-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("grow_abc_content_yesterday")
@ApiModel(value = "GrowAbcContentYesterday对象", description = "总览_学习指导表")
public class GrowAbcContentYesterday implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "角色")
    @TableField("role")
    private String role;

    @ApiModelProperty(value = "日期")
    @TableField("date")
    private LocalDate date;

    @ApiModelProperty(value = "级别")
    @TableField("level")
    private String level;

    @ApiModelProperty(value = "主题")
    @TableField("topic")
    private String topic;

    @ApiModelProperty(value = "课节")
    @TableField("lesson")
    private String lesson;

    @ApiModelProperty(value = "是否是新增")
    @TableField("add")
    private String add;


}
