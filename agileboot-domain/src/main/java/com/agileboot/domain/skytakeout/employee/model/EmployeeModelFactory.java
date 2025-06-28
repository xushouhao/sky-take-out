package com.agileboot.domain.skytakeout.employee.model;
import com.agileboot.common.exception.ApiException;
import com.agileboot.common.exception.error.ErrorCode.Business;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author valarchie
 */
@Component
@RequiredArgsConstructor
public class EmployeeModelFactory {

    private final EmployeeService employeeService;

    public EmployeeModel loadById(Integer id) {
        EmployeeEntity entity = employeeService.getById(id);
        if (entity == null) {
            throw new ApiException(Business.COMMON_OBJECT_NOT_FOUND, "员工");
        }
        return new EmployeeModel(entity, employeeService);
    }

    public EmployeeModel create() {
        return new EmployeeModel(employeeService);
    }

}
