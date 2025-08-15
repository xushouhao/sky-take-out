package com.agileboot.domain.skytakeout.category;

import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.skytakeout.category.command.AddCategoryCommand;
import com.agileboot.domain.skytakeout.category.command.UpdateCategoryCommand;
import com.agileboot.domain.skytakeout.category.db.CategoryEntity;
import com.agileboot.domain.skytakeout.category.db.CategoryService;
import com.agileboot.domain.skytakeout.category.dto.CategoryDTO;
import com.agileboot.domain.skytakeout.category.model.CategoryModel;
import com.agileboot.domain.skytakeout.category.model.CategoryModelFactory;
import com.agileboot.domain.skytakeout.category.query.CategoryQuery;
import com.agileboot.domain.skytakeout.employee.command.AddEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.command.UpdateEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import com.agileboot.domain.skytakeout.employee.dto.EmployeeDTO;
import com.agileboot.domain.skytakeout.employee.model.EmployeeModel;
import com.agileboot.domain.skytakeout.employee.model.EmployeeModelFactory;
import com.agileboot.domain.skytakeout.employee.query.EmployeeQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author valarchie
 */
@Service
@RequiredArgsConstructor
public class CategoryApplicationService {
    private final CategoryService service;
    private final CategoryModelFactory modelFactory;

    public PageDTO<CategoryDTO> getlist(CategoryQuery query) {
        Page<CategoryEntity> page = service.page(query.toPage(), query.toQueryWrapper());
        List<CategoryDTO> list = page.getRecords().stream()
                .map(CategoryDTO::new)
                .collect(Collectors.toList());
        return new PageDTO<>(list, page.getTotal());
    }

    public void addCategory(AddCategoryCommand command) {
        CategoryModel model = modelFactory.create();
        model.loadAddCommand(command);
        model.insert();
    }

    public void deleteCategory(Integer id) {
        CategoryModel model = modelFactory.loadById(id);
        model.deleteById(id);

    }

    public CategoryDTO getCategoryById(Integer id) {
        CategoryModel model = modelFactory.loadById(id);
        return new CategoryDTO(model);
    }

    public void updateCategory(UpdateCategoryCommand command) {
        CategoryModel model = modelFactory.loadById(command.getId());
        model.loadUpdateCommand(command);
        model.updateById();
    }

    public void updateCategoryStatus(Integer id, Integer status) {
        CategoryModel model = modelFactory.loadById(id);
        model.setStatus(status);
        model.updateById();
    }
}
