package com.agileboot.domain.skytakeout.employee.dto;

import cn.hutool.core.bean.BeanUtil;
import com.agileboot.common.annotation.ExcelColumn;
import com.agileboot.domain.skytakeout.employee.db.EmployeeEntity;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author valarchie
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO extends EmployeeEntity{

    public EmployeeDTO(EmployeeEntity entity) {
        if (entity != null) {
            BeanUtil.copyProperties(entity, this);
        }
    }

    @ExcelColumn(name = "员工姓名")
    private String name;


    @ExcelColumn(name = "员工账号")
    private String username;

    @ExcelColumn(name = "手机号码")
    private String phone;

    @ExcelColumn(name = "账号状态")
    private Integer status;

    @ExcelColumn(name = "最后操作时间")
    private Date updateTime;

}
