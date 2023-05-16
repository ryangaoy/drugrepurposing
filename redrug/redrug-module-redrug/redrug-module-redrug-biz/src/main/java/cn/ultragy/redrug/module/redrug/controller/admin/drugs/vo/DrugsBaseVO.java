package cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 药物信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class DrugsBaseVO {

    @Schema(description = "名称", example = "芋艿")
    private String generalName;

    @Schema(description = "常用叫法")
    private String knownAs;

    @Schema(description = "分类")
    private String groups;

    @Schema(description = "分子式")
    private String molecular;

    @Schema(description = "重原子数")
    private String atomicN;

    @Schema(description = "结构")
    private String structure;

    @Schema(description = "制造商")
    private String manufacturers;

    @Schema(description = "适应症")
    private String indication;

    @Schema(description = "靶点")
    private String targets;

    @Schema(description = "Uniprot ID", example = "19031")
    private String uniprotId;

}
