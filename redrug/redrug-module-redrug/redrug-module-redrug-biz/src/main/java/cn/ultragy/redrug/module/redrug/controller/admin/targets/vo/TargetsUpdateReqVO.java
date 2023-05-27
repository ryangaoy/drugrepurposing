package cn.ultragy.redrug.module.redrug.controller.admin.targets.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 靶点pdb更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TargetsUpdateReqVO extends TargetsBaseVO {

    @Schema(description = "id", required = true, example = "23030")
    @NotNull(message = "id不能为空")
    private Integer id;

}
