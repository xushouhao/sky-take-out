package com.agileboot.admin.controller.skytakeout;

import com.agileboot.common.core.base.BaseController;
import com.agileboot.common.core.dto.ResponseDTO;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.skytakeout.employee.EmployeeApplicationService;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import com.agileboot.domain.skytakeout.employee.dto.EmployeeDTO;
import com.agileboot.domain.skytakeout.employee.query.EmployeeQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author evil
 * @date 2025/6/20
 * @description 员工请求相关接口
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/employee")
public class AdminEmployeeController extends BaseController {
    private final EmployeeService employeeService;
    private final EmployeeApplicationService employeeApplicationService;

    @GetMapping("/list")
    public ResponseDTO<PageDTO<EmployeeDTO>> listEmployees(EmployeeQuery query) {
        PageDTO<EmployeeDTO> page = employeeApplicationService.listEmployees(query);
        return ResponseDTO.ok(page);
    }

}
