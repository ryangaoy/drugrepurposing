package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - ipa预测适应症single更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IpaDiseaseSingleUpdateReqVO extends IpaDiseaseSingleBaseVO {

    @Schema(description = "id", required = true, example = "18361")
    @NotNull(message = "id不能为空")
    private Integer id;

}
