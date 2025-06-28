package com.agileboot.domain.skytakeout.employee;

import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.skytakeout.employee.command.AddEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.command.UpdateEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import com.agileboot.domain.skytakeout.employee.dto.EmployeeDTO;
import com.agileboot.domain.skytakeout.employee.model.EmployeeModel;
import com.agileboot.domain.skytakeout.employee.model.EmployeeModelFactory;
import com.agileboot.domain.skytakeout.employee.query.EmployeeQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author valarchie
 */
@Service
@RequiredArgsConstructor
public class EmployeeApplicationService {

    private final EmployeeService employeeService;
    private final EmployeeModelFactory employeeModelFactory;

    public PageDTO<EmployeeDTO> listEmployees(EmployeeQuery query) {
        Page<EmployeeEntity> page = employeeService.page(query.toPage(), query.toQueryWrapper());

        List<EmployeeDTO> records = page.getRecords().stream().map(EmployeeDTO::new).collect(Collectors.toList());
        return new PageDTO<>(records, page.getTotal());
    }

    @Transactional(rollbackFor = Exception.class)
    public void addEmployee(AddEmployeeCommand command) {
        EmployeeModel model = employeeModelFactory.create();
        model.loadEmployeeAddCommand(command);
        model.insert();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        EmployeeModel model = employeeModelFactory.loadById(id);
        model.deleteById(id);
    }

    public EmployeeDTO getEmployeeById(Integer id) {
        EmployeeModel model = employeeModelFactory.loadById(id);
        EmployeeEntity entity = model.selectById();
        return new EmployeeDTO(entity);
    }

    public void updateEmployee(UpdateEmployeeCommand command) {
        EmployeeModel model = employeeModelFactory.loadById(command.getId());
        model.loadEmployeeUpdateCommand(command);
        model.updateById();
    }
}
