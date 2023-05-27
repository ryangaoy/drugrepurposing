package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - ipa预测适应症all更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IpaDiseaseAllUpdateReqVO extends IpaDiseaseAllBaseVO {

    @Schema(description = "id", required = true, example = "21599")
    @NotNull(message = "id不能为空")
    private Integer id;

}
