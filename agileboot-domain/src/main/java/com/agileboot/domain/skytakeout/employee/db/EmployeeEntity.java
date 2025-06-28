package com.agileboot.domain.skytakeout.employee.db;

import com.agileboot.common.core.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 员工信息表
 * </p>
 */
@Getter
@Setter
@TableName("tb_employee")
@ApiModel(value = "EmployeeEntity对象", description = "员工信息表")
public class EmployeeEntity extends BaseEntity<EmployeeEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("员工ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("身份证号")
    @TableField("id_number")
    private String idNumber;

    @ApiModelProperty("账号状态（1正常 0锁定）")
    @TableField("status")
    private Integer status;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}