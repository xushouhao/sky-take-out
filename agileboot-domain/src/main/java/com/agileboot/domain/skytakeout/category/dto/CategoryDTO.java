package com.agileboot.domain.skytakeout.category.dto;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.common.annotation.ExcelColumn;
import com.agileboot.domain.skytakeout.category.db.CategoryEntity;
import com.agileboot.domain.skytakeout.category.enums.CategoryEnum;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.enums.EmployeeSexEnum;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author valarchie
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO extends CategoryEntity {


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

    @ApiModelProperty("分类状态（1正常 0禁用）")
    private Integer status;

    public CategoryDTO(CategoryEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }

}
