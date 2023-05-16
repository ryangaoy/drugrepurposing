package cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "管理后台 - 药物信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DrugsRespVO extends DrugsBaseVO {

    @Schema(description = "ID", required = true, example = "1681")
    private String drugbankId;

}
