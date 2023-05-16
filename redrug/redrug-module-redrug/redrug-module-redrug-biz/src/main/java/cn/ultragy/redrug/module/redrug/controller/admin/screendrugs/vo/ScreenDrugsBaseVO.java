package cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 筛选药物 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class ScreenDrugsBaseVO {

    @Schema(description = "drugbank id", example = "25256")
    private String drugbankId;

    @Schema(description = "name", example = "赵六")
    private String name;

    @Schema(description = "desc", example = "随便")
    private String description;

    @Schema(description = "cas")
    private String casNumber;

    @Schema(description = "amass")
    private Double averageMass;

    @Schema(description = "mmass")
    private Double monoisotopicMass;

    @Schema(description = "group")
    private String groups;

    @Schema(description = "ref")
    private String synthesisReference;

    @Schema(description = "indi")
    private String indication;

    @Schema(description = "phar")
    private String pharmacodynamics;

    @Schema(description = "absor")
    private String absorption;

    @Schema(description = "vod")
    private String volumeOfDistribution;

    @Schema(description = "probinding")
    private String proteinBinding;

    @Schema(description = "meta")
    private String metabolism;

    @Schema(description = "route")
    private String routeOfElimination;

    @Schema(description = "h life")
    private String halfLife;

    @Schema(description = "clear")
    private String clearance;

    @Schema(description = "mol")
    private String molecular;

    @Schema(description = "atomic num")
    private Short atomicN;

    @Schema(description = "manu")
    private String manufacturers;

    @Schema(description = "gene")
    private String pubmedGene;

}
