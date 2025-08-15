package com.agileboot.domain.skytakeout.category.model;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.domain.skytakeout.category.command.AddCategoryCommand;
import com.agileboot.domain.skytakeout.category.command.UpdateCategoryCommand;
import com.agileboot.domain.skytakeout.category.db.CategoryEntity;
import com.agileboot.domain.skytakeout.category.db.CategoryService;
import com.agileboot.domain.skytakeout.employee.command.AddEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.command.UpdateEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import lombok.NoArgsConstructor;

/**
 * @author valarchie
 */
@NoArgsConstructor
public class CategoryModel extends CategoryEntity {

    private CategoryService service;

    public CategoryModel(CategoryService service) {
        this.service = service;
    }

    public CategoryModel(CategoryEntity entity, CategoryService employeeService) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
        this.service = service;
    }


    public void loadAddCommand(AddCategoryCommand command) {
        if (command != null) {
            BeanUtil.copyProperties(command, this);
        }
    }

    public void loadUpdateCommand(UpdateCategoryCommand command) {
        if (command != null) {
            BeanUtil.copyProperties(command, this, "id");
        }
    }
}
