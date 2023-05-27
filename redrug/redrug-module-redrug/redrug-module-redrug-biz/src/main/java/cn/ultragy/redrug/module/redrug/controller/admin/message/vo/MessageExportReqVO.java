package cn.ultragy.redrug.module.redrug.controller.admin.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.ultragy.redrug.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户消息 Excel 导出 Request VO，参数和 MessagePageReqVO 是一致的")
@Data
public class MessageExportReqVO {

    @Schema(description = "name", example = "王五")
    private String name;

    @Schema(description = "email")
    private String email;

    @Schema(description = "phone")
    private String phone;

    @Schema(description = "message")
    private String message;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
