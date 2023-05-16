package cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 基因通路 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PathwaysRespVO extends PathwaysBaseVO {

    @Schema(description = "id", required = true, example = "13338")
    private Integer id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
