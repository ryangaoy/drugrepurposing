package cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - drug_pdb Excel 导出 Request VO，参数和 DrugPdbPageReqVO 是一致的")
@Data
public class DrugPdbExportReqVO {

    @Schema(description = "drugbankid", example = "3264")
    private String drugbankId;

    @Schema(description = "PDBID", example = "26276")
    private String pdbId;

    @Schema(description = "打分")
    private String score;

    @Schema(description = "结合效率")
    private String bindingRate;

}
