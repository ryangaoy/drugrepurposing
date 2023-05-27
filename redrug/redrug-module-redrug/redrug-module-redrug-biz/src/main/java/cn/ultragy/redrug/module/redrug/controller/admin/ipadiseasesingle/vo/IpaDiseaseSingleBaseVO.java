package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* ipa预测适应症single Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class IpaDiseaseSingleBaseVO {

    @Schema(description = "drugbank id", example = "17696")
    private String drugbankId;

    @Schema(description = "基因")
    private String gene;

    @Schema(description = "功能")
    private String dfunction;

    @Schema(description = "适应症")
    private String disease;

}
