package cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 基因通路更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PathwaysUpdateReqVO extends PathwaysBaseVO {

    @Schema(description = "id", required = true, example = "13338")
    @NotNull(message = "id不能为空")
    private Integer id;

}
