package com.agileboot.domain.skytakeout.employee.command;

import com.agileboot.domain.system.post.command.AddPostCommand;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author valarchie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateEmployeeCommand extends AddPostCommand {

    @NotNull(message = "岗位ID不能为空")
    @Positive
    private Long postId;

}
