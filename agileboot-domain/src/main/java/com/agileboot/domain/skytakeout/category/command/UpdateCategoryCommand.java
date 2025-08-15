package com.agileboot.domain.skytakeout.category.command;


import lombok.Data;

@Data
public class UpdateCategoryCommand extends AddCategoryCommand {

    /**
     * 分类ID
     */
    private Integer id;


}
