package com.agileboot.domain.skytakeout.category.query;

import cn.hutool.core.util.ObjectUtil;
import com.agileboot.common.core.page.AbstractPageQuery;
import com.agileboot.domain.skytakeout.category.db.CategoryEntity;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author valarchie
 */
@Data
@Getter
@Setter
public class CategoryQuery extends AbstractPageQuery<CategoryEntity> {

    // 查询参数（前端传入）
    private String name;      // 分类姓名，支持模糊查询
    private Integer type;      // 分类类型

    @Override
    public QueryWrapper<CategoryEntity> addQueryCondition() {
        QueryWrapper<CategoryEntity> queryWrapper = new QueryWrapper<>();
        // 添加查询条件
        queryWrapper.like(ObjectUtil.isNotEmpty(name), "name", name)
                .eq(ObjectUtil.isNotEmpty(type), "type", type);


        // 设置按时间范围查询字段（由 AbstractPageQuery 控制时间过滤逻辑）
        this.setTimeRangeColumn("create_time");

        return queryWrapper;
    }
}
