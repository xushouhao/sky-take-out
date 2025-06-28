package com.agileboot.domain.skytakeout.employee.query;

import cn.hutool.core.util.StrUtil;
import com.agileboot.common.core.page.AbstractPageQuery;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author valarchie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeQuery extends AbstractPageQuery<EmployeeEntity> {

    private String name;
    private String userName;
    private Integer sex;

    @Override
    public QueryWrapper<EmployeeEntity> addQueryCondition() {
        QueryWrapper<EmployeeEntity> queryWrapper = new QueryWrapper<EmployeeEntity>()
            .eq(name != null, "name", name)
            .like(StrUtil.isNotEmpty(userName), "userName", userName);
        this.setTimeRangeColumn("create_time");

        return queryWrapper;
    }
}
