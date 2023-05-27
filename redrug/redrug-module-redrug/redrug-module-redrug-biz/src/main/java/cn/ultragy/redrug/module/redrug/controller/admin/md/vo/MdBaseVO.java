package cn.ultragy.redrug.module.redrug.controller.admin.md.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 分子动力学模拟结果列 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MdBaseVO {

    @Schema(description = "drugbank id", example = "19931")
    private String drugbankId;

    @Schema(description = "entry")
    private String entrys;

    @Schema(description = "蛋白质")
    private String proteinNames;

    @Schema(description = "pdb id")
    private String pdb;

    @Schema(description = "uniprotid", example = "24957")
    private String uniprotId;

    @Schema(description = "物种")
    private String organism;

    @Schema(description = "大小")
    private Integer lengths;

}
