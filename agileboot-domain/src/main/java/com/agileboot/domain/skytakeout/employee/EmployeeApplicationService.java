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

    /**
     * 分页查询员工列表
     *
     * @param query
     * @return
     */
    public PageDTO<EmployeeDTO> listEmployees(EmployeeQuery query) {
        Page<EmployeeEntity> page = employeeService.page(query.toPage(), query.toQueryWrapper());

        List<EmployeeDTO> records = page.getRecords().stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toList());
        return new PageDTO<>(records, page.getTotal());
    }

    /**
     * 添加员工
     *
     * @param command
     */
    @Transactional(rollbackFor = Exception.class)
    public void addEmployee(AddEmployeeCommand command) {
        EmployeeModel model = employeeModelFactory.create();
        if (command.getPhone().length() != 11) {
            throw new IllegalArgumentException("手机号长度必须为11位");
        }
        if (command.getIdNumber().length() != 18) {
            throw new IllegalArgumentException("身份证号长度必须为18位");
        }
        model.setPassword("123456"); // 默认密码
        model.loadEmployeeAddCommand(command);
        model.insert();
    }

    /**
     * 删除员工
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteById(Integer id) {
        EmployeeModel model = employeeModelFactory.loadById(id);
        model.deleteById(id);
    }

    /**
     * 根据ID查询员工信息
     *
     * @param id
     * @return
     */
    public EmployeeDTO getEmployeeById(Integer id) {
        EmployeeModel model = employeeModelFactory.loadById(id);
        EmployeeEntity entity = model.selectById();
        return new EmployeeDTO(entity);
    }

    /**
     * 更新员工信息
     *
     * @param command
     */
    public void updateEmployee(UpdateEmployeeCommand command) {
        EmployeeModel model = employeeModelFactory.loadById(command.getId());
        model.loadEmployeeUpdateCommand(command);
        model.updateById();
    }
}
