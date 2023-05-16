package cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo;

import cn.ultragy.redrug.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 药物信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DrugsPageReqVO extends PageParam {

    @Schema(description = "id")
    private String drugbankId;

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
