package com.agileboot.domain.skytakeout.category.model;
import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode.Business;
import com.agileboot.domain.skytakeout.category.db.CategoryEntity;
import com.agileboot.domain.skytakeout.category.db.CategoryService;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author valarchie
 */
@Component
@RequiredArgsConstructor
public class CategoryModelFactory {

    private final CategoryService service;

    public CategoryModel loadById(Integer id) {
        CategoryEntity entity = service.getById(id);
        if (entity == null) {
            throw new ApiException(Business.COMMON_OBJECT_NOT_FOUND, "员工");
        }
        return new CategoryModel(entity, service);
    }

    public CategoryModel create() {
        return new CategoryModel(service);
    }

}
