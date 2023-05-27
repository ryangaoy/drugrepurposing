package cn.ultragy.redrug.module.redrug.controller.admin.md.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.ultragy.redrug.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 分子动力学模拟结果列 Excel 导出 Request VO，参数和 MdPageReqVO 是一致的")
@Data
public class MdExportReqVO {

    @Schema(description = "drugbank id", example = "19931")
    private String drugbankId;

    @Schema(description = "entry")
    private String entrys;

    @Schema(description = "蛋白质")
    private String proteinNames;

    @Schema(description = "pdb id")
    private String pdb;

    @Schema(description = "uniprotid", example = "24957")
    private String uniprotId;

    @Schema(description = "物种")
    private String organism;

    @Schema(description = "大小")
    private Integer lengths;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
