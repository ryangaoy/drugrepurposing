package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo;

import cn.ultragy.redrug.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - ipa预测适应症all分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IpaDiseaseAllPageReqVO extends PageParam {

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
