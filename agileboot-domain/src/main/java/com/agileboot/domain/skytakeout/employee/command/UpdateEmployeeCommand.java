package com.agileboot.domain.skytakeout.employee.command;

import com.agileboot.domain.system.post.command.AddPostCommand;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author valarchie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateEmployeeCommand extends AddEmployeeCommand {

    @NotNull
    @Schema(description = "员工ID")
    private Integer id;

    @NotNull
    @Schema(description = "账号状态")
    private Integer status;

}
