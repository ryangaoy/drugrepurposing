package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - ipa预测适应症all Excel 导出 Request VO，参数和 IpaDiseaseAllPageReqVO 是一致的")
@Data
public class IpaDiseaseAllExportReqVO {

    @Schema(description = "id", example = "21599")
    private Integer id;

    @Schema(description = "drugbank id", example = "6234")
    private String drugbankId;

    @Schema(description = "来源")
    private String fromM;

    @Schema(description = "类型")
    private String typeM;

    @Schema(description = "目标")
    private String toM;

    @Schema(description = "catalyst")
    private String catalyst;

}
