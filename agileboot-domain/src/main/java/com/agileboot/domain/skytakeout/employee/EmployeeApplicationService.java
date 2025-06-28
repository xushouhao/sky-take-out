package com.agileboot.domain.skytakeout.employee;

import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import com.agileboot.domain.skytakeout.employee.dto.EmployeeDTO;
import com.agileboot.domain.skytakeout.employee.query.EmployeeQuery;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author valarchie
 */
@Service
@RequiredArgsConstructor
public class EmployeeApplicationService {

    private final EmployeeService employeeService;

    public PageDTO<EmployeeDTO> listEmployees(EmployeeQuery query) {
        Page<EmployeeEntity> page = employeeService.page(query.toPage(), query.toQueryWrapper());

        List<EmployeeDTO> records = page.getRecords().stream().map(EmployeeDTO::new).collect(Collectors.toList());
        return new PageDTO<>(records, page.getTotal());
    }
}
