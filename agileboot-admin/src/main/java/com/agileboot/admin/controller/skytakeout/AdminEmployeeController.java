package com.agileboot.admin.controller.skytakeout;

import com.agileboot.common.core.base.BaseController;
import com.agileboot.common.core.dto.ResponseDTO;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.skytakeout.employee.EmployeeApplicationService;
import com.agileboot.domain.skytakeout.employee.command.AddEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.command.UpdateEmployeeCommand;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import com.agileboot.domain.skytakeout.employee.dto.EmployeeDTO;
import com.agileboot.domain.skytakeout.employee.query.EmployeeQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author evil
 * @date 2025/6/20
 * @description 员工请求相关接口
 */
@Tag(name = "员工API", description = "员工请求相关接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("admin/employee")
public class AdminEmployeeController extends BaseController {

    private final EmployeeService employeeService;
    private final EmployeeApplicationService employeeApplicationService;

    /**
     * 获取员工列表
     *
     * @param query 查询条件
     * @return 员工列表
     */
    @Operation(summary = "获取员工列表", description = "获取员工列表")
    @GetMapping("/list")
    public ResponseDTO<PageDTO<EmployeeDTO>> listEmployees(EmployeeQuery query) {
        PageDTO<EmployeeDTO> page = employeeApplicationService.listEmployees(query);
        return ResponseDTO.ok(page);
    }

    /**
     * 添加员工
     *
     * @param command 添加员工命令
     * @return 响应结果
     */
    @Operation(summary = "添加员工", description = "添加员工")
    @PostMapping
    public ResponseDTO<Void> addEmployee(@RequestBody AddEmployeeCommand command) {
        employeeApplicationService.addEmployee(command);
        return ResponseDTO.ok();
    }

    /**
     * 删除员工
     *
     * @param id 员工ID
     * @return 响应结果
     */
    @Parameter(name = "id", description = "员工ID", in = ParameterIn.PATH, required = true)
    @Operation(summary = "删除员工", description = "删除员工")
    @DeleteMapping("/{id}")
    public ResponseDTO<Void> deleteEmployee(@PathVariable Integer id) {
        employeeApplicationService.deleteById(id);
        return ResponseDTO.ok();
    }

    /**
     * 更新员工信息
     *
     * @param command 更新员工命令
     * @return 响应结果
     */
    @Operation(summary = "更新员工信息", description = "更新员工信息")
    @PutMapping
    public ResponseDTO<Void> updateEmployee(@RequestBody UpdateEmployeeCommand command) {
        employeeApplicationService.updateEmployee(command);
        return ResponseDTO.ok();

    }


    /**
     * 根据ID获取员工信息
     *
     * @param id 员工ID
     * @return 员工信息
     */
    @Parameter(name = "id", description = "员工ID", in = ParameterIn.PATH, required = true)
    @Operation(summary = "根据ID获取员工信息", description = "根据ID获取员工信息")
    @GetMapping("/{id}")
    public ResponseDTO<EmployeeDTO> getEmployeeById(@PathVariable Integer id) {
        return ResponseDTO.ok(employeeApplicationService.getEmployeeById(id));
    }


}
