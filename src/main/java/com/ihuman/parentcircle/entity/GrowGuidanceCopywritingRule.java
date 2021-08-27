package com.ihuman.parentcircle.entity;

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
 * 文案规则表
 * </p>
 *
 * @author madepeng
 * @since 2021-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("grow_guidance_copywriting_rule")
@ApiModel(value = "GrowGuidanceCopywritingRule对象", description = "文案规则表")
public class GrowGuidanceCopywritingRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "科目,0总览1拼音2识字3abc4思维")
    @TableField("app_name")
    private Boolean appName;

    @ApiModelProperty(value = "阶段")
    @TableField("stage")
    private String stage;

    @ApiModelProperty(value = "是否掌握0未掌握1掌握")
    @TableField("mastered")
    private Integer mastered;

    @ApiModelProperty(value = "是否掌握的内容")
    @TableField("master_content")
    private String masterContent;

    @ApiModelProperty(value = "创建人")
    @TableField("create_user")
    private String createUser;

    @ApiModelProperty(value = "更新人")
    @TableField("update_user")
    private String updateUser;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
