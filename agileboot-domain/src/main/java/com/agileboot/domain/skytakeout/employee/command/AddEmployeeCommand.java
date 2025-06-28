package com.agileboot.domain.skytakeout.employee.command;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author evil
 */
@Data
public class AddEmployeeCommand {

    @NotBlank
    @Schema(description = "员工姓名")
    private String name;

    @NotBlank
    @Schema(description = "用户名")
    private String username;

    @NotBlank
    @Schema(description = "手机号")
    private String phone;

    @NotBlank
    @Schema(description = "性别")
    private Integer sex;

    @NotBlank
    @Schema(description = "身份证号")
    private String idNumber;


}
