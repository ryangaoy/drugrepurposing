package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - ipa预测适应症single Excel 导出 Request VO，参数和 IpaDiseaseSinglePageReqVO 是一致的")
@Data
public class IpaDiseaseSingleExportReqVO {

    @Schema(description = "drugbank id", example = "17696")
    private String drugbankId;

    @Schema(description = "基因")
    private String gene;

    @Schema(description = "功能")
    private String dfunction;

    @Schema(description = "适应症")
    private String disease;

}
