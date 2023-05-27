package cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 筛选药物 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ScreenDrugsRespVO extends ScreenDrugsBaseVO {

    @Schema(description = "id", required = true, example = "4747")
    private Integer id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
