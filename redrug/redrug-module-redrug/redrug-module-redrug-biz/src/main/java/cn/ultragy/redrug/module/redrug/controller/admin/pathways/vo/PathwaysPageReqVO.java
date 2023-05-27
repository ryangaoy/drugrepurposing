package cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo;

import cn.ultragy.redrug.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.ultragy.redrug.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 基因通路分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PathwaysPageReqVO extends PageParam {

    @Schema(description = "drugbank id", example = "15165")
    private String drugbankId;

    @Schema(description = "名称", example = "王五")
    private String generalName;

    @Schema(description = "常用叫法")
    private String knownAs;

    @Schema(description = "passway id", example = "20330")
    private String passwayId;

    @Schema(description = "描述")
    private String pathwayDesc;

    @Schema(description = "错误率")
    private String falseDiscoveryRate;

    @Schema(description = "标签")
    private String labels;

    @Schema(description = "标签id")
    private String labelsIds;

    @Schema(description = "pdbids")
    private String pdbids;

    @Schema(description = "pdbids_list")
    private String pdbidsList;

    @Schema(description = "pdbid_all")
    private String pdbidAll;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
