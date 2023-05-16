package cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 基因通路 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PathwaysBaseVO {

    @Schema(description = "drugbank id", example = "15165")
    private String drugbankId;

    @Schema(description = "名称", example = "王五")
    private String generalName;

    @Schema(description = "常用叫法")
    private String knownAs;

    @Schema(description = "passway id", example = "20330")
    private String passwayId;

    @Schema(description = "描述")
    private String pathwayDesc;

    @Schema(description = "错误率")
    private String falseDiscoveryRate;

    @Schema(description = "标签")
    private String labels;

    @Schema(description = "标签id")
    private String labelsIds;

    @Schema(description = "pdbids")
    private String pdbids;

    @Schema(description = "pdbids_list")
    private String pdbidsList;

    @Schema(description = "pdbid_all")
    private String pdbidAll;

}
