package com.agileboot.domain.skytakeout.category.command;

import com.agileboot.domain.skytakeout.category.enums.CategoryEnum;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AddCategoryCommand {

    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类排序
     */
    private Integer sort;
    /**
     * 分类类型
     */
    private CategoryEnum type;
    /**
     * 分类状态（1正常 0禁用）
     */
    private Integer status;

}
