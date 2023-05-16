package cn.ultragy.redrug.module.redrug.controller.admin.md.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.ultragy.redrug.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 分子动力学模拟结果列分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MdPageReqVO extends PageParam {

    @Schema(description = "id", example = "1")
    private Integer id;

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
