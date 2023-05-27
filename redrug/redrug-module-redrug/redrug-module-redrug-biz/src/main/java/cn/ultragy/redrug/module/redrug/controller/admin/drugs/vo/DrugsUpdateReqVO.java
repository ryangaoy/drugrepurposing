package cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 药物信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DrugsUpdateReqVO extends DrugsBaseVO {

    @Schema(description = "ID", required = true, example = "1681")
    @NotNull(message = "ID不能为空")
    private String drugbankId;

}
