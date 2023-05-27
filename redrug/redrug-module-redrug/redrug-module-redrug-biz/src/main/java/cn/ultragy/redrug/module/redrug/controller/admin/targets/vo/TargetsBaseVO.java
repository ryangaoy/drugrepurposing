package cn.ultragy.redrug.module.redrug.controller.admin.targets.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 靶点pdb Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class TargetsBaseVO {

    @Schema(description = "pdb")
    private String pdb;

    @Schema(description = "uniprotid", example = "12790")
    private String uniprotId;

    @Schema(description = "基因")
    private String geneNames;

    @Schema(description = "物种")
    private String organism;

    @Schema(description = "蛋白质")
    private String proteinNames;

    @Schema(description = "大小")
    private String lengths;

    @Schema(description = "ec")
    private String ecNumber;

    @Schema(description = "功能")
    private String functions;

    @Schema(description = "pubmedid", example = "591")
    private String pubmedId;

    @Schema(description = "entry")
    private String entrys;

}
