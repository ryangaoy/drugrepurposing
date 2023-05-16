package cn.ultragy.redrug.module.redrug.controller.admin.targets.vo;

import cn.ultragy.redrug.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.ultragy.redrug.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 靶点pdb分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TargetsPageReqVO extends PageParam {

    @Schema(description = "pdb")
    private String pdb;

    @Schema(description = "uniprotid", example = "12790")
    private String uniprotId;

    @Schema(description = "基因")
    private String geneNames;

    @Schema(description = "物种")
    private String organism;

    @Schema(description = "蛋白质")
    private String proteinNames;

    @Schema(description = "大小")
    private String lengths;

    @Schema(description = "ec")
    private String ecNumber;

    @Schema(description = "功能")
    private String functions;

    @Schema(description = "pubmedid", example = "591")
    private String pubmedId;

    @Schema(description = "entry")
    private String entrys;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
