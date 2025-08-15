package com.agileboot.domain.skytakeout.category.db;

import com.agileboot.common.core.base.BaseEntity;
import com.agileboot.domain.skytakeout.category.enums.CategoryEnum;
import com.agileboot.domain.skytakeout.employee.enums.EmployeeSexEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 分类信息表
 * </p>
 */
@Getter
@Setter
@TableName("tb_category")
@ApiModel(value = "CategoryEntity对象", description = "分类信息表")
public class CategoryEntity extends BaseEntity<CategoryEntity> {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty("分类ID")
    private Integer id;

    @TableField("name")
    @ApiModelProperty("分类名称")
    private String name;

    @TableField("sort")
    @ApiModelProperty("分类排序")
    private Integer sort;

    @TableField("type")
    @ApiModelProperty("分类类型")
    private CategoryEnum type;

    @TableField("status")
    @ApiModelProperty("分类状态（1正常 0禁用）")
    private Integer status;


}