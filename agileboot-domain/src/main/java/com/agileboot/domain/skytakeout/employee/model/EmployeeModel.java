package com.agileboot.domain.skytakeout.employee.model;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.domain.skytakeout.employee.command.AddEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.command.UpdateEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import com.agileboot.domain.system.post.command.AddPostCommand;
import com.agileboot.domain.system.post.command.UpdatePostCommand;
import com.agileboot.domain.system.post.db.SysPostService;
import lombok.NoArgsConstructor;

/**
 * @author valarchie
 */
@NoArgsConstructor
public class EmployeeModel extends EmployeeEntity {

    private EmployeeService employeeService;

    public EmployeeModel(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeModel(EmployeeEntity entity, EmployeeService employeeService) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
        this.employeeService = employeeService;
    }

    public void loadEmployeeAddCommand(AddEmployeeCommand command) {
        if (command != null) {
            BeanUtil.copyProperties(command, this, "id");
        }
        this.setPassword("123456");
    }

    public void loadEmployeeUpdateCommand(UpdateEmployeeCommand command) {
        if (command != null) {
            BeanUtil.copyProperties(command, this, "id");
        }
    }


}
