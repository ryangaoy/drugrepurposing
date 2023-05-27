package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - ipa预测适应症all Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IpaDiseaseAllRespVO extends IpaDiseaseAllBaseVO {

    @Schema(description = "id", required = true, example = "21599")
    private Integer id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
