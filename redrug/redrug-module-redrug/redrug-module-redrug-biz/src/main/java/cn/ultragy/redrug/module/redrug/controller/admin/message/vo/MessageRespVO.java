package cn.ultragy.redrug.module.redrug.controller.admin.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 用户消息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MessageRespVO extends MessageBaseVO {

    @Schema(description = "id", required = true, example = "12039")
    private Integer id;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
