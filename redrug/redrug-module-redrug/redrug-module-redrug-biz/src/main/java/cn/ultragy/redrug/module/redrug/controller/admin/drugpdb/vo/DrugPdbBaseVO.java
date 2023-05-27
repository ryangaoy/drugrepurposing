package cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* drug_pdb Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DrugPdbBaseVO {

    @Schema(description = "drugbankid", example = "3264")
    private String drugbankId;

    @Schema(description = "PDBID", example = "26276")
    private String pdbId;

    @Schema(description = "打分")
    private String score;

    @Schema(description = "结合效率")
    private String bindingRate;

}
