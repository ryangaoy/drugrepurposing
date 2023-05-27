package cn.ultragy.redrug.module.redrug.controller.admin.targets.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 靶点pdb Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TargetsRespVO extends TargetsBaseVO {

    @Schema(description = "id", required = true, example = "23030")
    private Integer id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
