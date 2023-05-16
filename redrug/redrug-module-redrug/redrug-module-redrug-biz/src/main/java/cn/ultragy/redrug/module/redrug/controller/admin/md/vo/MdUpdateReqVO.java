package cn.ultragy.redrug.module.redrug.controller.admin.md.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 分子动力学模拟结果列更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MdUpdateReqVO extends MdBaseVO {

    @Schema(description = "id", required = true, example = "3110")
    @NotNull(message = "id不能为空")
    private Integer id;

}
