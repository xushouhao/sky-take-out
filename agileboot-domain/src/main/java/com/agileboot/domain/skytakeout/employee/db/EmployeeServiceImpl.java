package com.agileboot.domain.skytakeout.employee.db;
import com.agileboot.common.core.page.PageDTO;
import com.agileboot.domain.skytakeout.employee.db.EmployeeService;
import com.agileboot.domain.skytakeout.employee.dto.EmployeeDTO;
import com.agileboot.domain.skytakeout.employee.query.EmployeeQuery;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author valarchie
 * @since 2022-06-16
 */
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, EmployeeEntity> implements EmployeeService {



}
