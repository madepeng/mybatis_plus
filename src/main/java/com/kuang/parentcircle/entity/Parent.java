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
 * 家长表
 * </p>
 *
 * @author madepeng
 * @since 2021-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("parent")
@ApiModel(value = "Parent对象", description = "家长表")
public class Parent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "名称")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty(value = "头像url")
    @TableField("avatar_url")
    private String avatarUrl;

    @ApiModelProperty(value = "手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty(value = "性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty(value = "生日")
    @TableField("birthday")
    private Integer birthday;

    @ApiModelProperty(value = "省")
    @TableField("province_id")
    private Integer provinceId;

    @ApiModelProperty(value = "市")
    @TableField("city_id")
    private Integer cityId;

    @ApiModelProperty(value = "县")
    @TableField("district_id")
    private Integer districtId;

    @ApiModelProperty(value = "详细地址")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "状态")
    @TableField("status")
    private Integer status;

    @ApiModelProperty(value = "逗号分隔的愿景列表")
    @TableField("vision_list")
    private String visionList;

    @ApiModelProperty(value = "积分总数量")
    @TableField("integral_sum")
    private Integer integralSum;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
