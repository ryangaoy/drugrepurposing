package cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo;

import cn.ultragy.redrug.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - drug_pdb分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DrugPdbPageReqVO extends PageParam {

    @Schema(description = "drugbankid", example = "3264")
    private String drugbankId;

    @Schema(description = "PDBID", example = "26276")
    private String pdbId;

    @Schema(description = "打分")
    private String score;

    @Schema(description = "结合效率")
    private String bindingRate;

}
