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

    public EmployeeModel loadById(Long postId) {
        EmployeeEntity byId = employeeService.getById(postId);
        if (byId == null) {
            throw new ApiException(Business.COMMON_OBJECT_NOT_FOUND, "职位");
        }
        return new EmployeeModel(byId, employeeService);
    }

    public EmployeeModel create() {
        return new EmployeeModel(employeeService);
    }

}
