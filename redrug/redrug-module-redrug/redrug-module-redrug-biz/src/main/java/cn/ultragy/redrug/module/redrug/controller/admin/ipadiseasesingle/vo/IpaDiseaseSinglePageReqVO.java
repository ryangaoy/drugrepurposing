package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo;

import cn.ultragy.redrug.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - ipa预测适应症single分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IpaDiseaseSinglePageReqVO extends PageParam {

    @Schema(description = "drugbank id", example = "17696")
    private String drugbankId;

    @Schema(description = "基因")
    private String gene;

    @Schema(description = "功能")
    private String dfunction;

    @Schema(description = "适应症")
    private String disease;

}
