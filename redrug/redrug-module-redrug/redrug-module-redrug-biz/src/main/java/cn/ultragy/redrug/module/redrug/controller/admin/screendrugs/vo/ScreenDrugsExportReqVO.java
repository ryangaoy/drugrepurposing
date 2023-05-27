package cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 筛选药物 Excel 导出 Request VO，参数和 ScreenDrugsPageReqVO 是一致的")
@Data
public class ScreenDrugsExportReqVO {

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
