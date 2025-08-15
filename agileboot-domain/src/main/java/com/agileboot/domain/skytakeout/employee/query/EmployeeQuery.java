package com.agileboot.domain.skytakeout.employee.query;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.agileboot.common.core.page.AbstractPageQuery;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.agileboot.domain.skytakeout.employee.enums.EmployeeSexEnum;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author valarchie
 */
@Data
@Getter
@Setter
public class EmployeeQuery extends AbstractPageQuery<EmployeeEntity> {

    // 查询参数（前端传入）
    private String name;      // 员工姓名，支持模糊查询
    private String username;  // 用户账号，支持模糊查询
    private Integer sex;      // 性别，精确匹配：0=女，1=男

    @Override
    public QueryWrapper<EmployeeEntity> addQueryCondition() {
        QueryWrapper<EmployeeEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(ObjectUtil.isNotEmpty(name), "name", name)
                .like(ObjectUtil.isNotEmpty(username), "username", username)
                .eq(ObjectUtil.isNotEmpty(sex),"sex", sex);


        // 设置按时间范围查询字段（由 AbstractPageQuery 控制时间过滤逻辑）
        this.setTimeRangeColumn("create_time");

        return queryWrapper;
    }
}
