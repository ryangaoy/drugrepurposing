package cn.ultragy.redrug.module.redrug.controller.admin.screen.vo;

import cn.ultragy.redrug.framework.common.pojo.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import static cn.ultragy.redrug.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 筛选结果分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ScreenPageReqVO extends PageParam {

    @Schema(description = "drugbank id", example = "23482")
    private String drugbankId;

    @Schema(description = "uniprot id", example = "21438")
    private String uniprotId;

    @Schema(description = "tg name", example = "李四")
    private String tgname;

    @Schema(description = "pdb", example = "21717")
    private String pdbid;

    @Schema(description = "score")
    private Double score;

    @Schema(description = "结合效率")
    private Double bindingRate;

    @Schema(description = "tgname pubmed num")
    private String uniprotTgnameMedN;

    @Schema(description = "tgname pubmed list")
    private String uniprotTgnameMedList;

    @Schema(description = "tgshort pubmed num")
    private Integer uniprotTgshortMedN;

    @Schema(description = "tgshort pubmed list")
    private String uniprotTgshortMedList;

    @Schema(description = "alname pubmed num")
    private Integer alternativeNameMedN;

    @Schema(description = "alname pubmed list")
    private String alternativeNameMedList;

    @Schema(description = "unidisease pubmed num")
    private Integer uniprotDiseaseMedN;

    @Schema(description = "unidisease pubmed list")
    private String uniprotDiseaseMedList;

    @Schema(description = "unigene pubmed num")
    private Integer uniprotGeneMedN;

    @Schema(description = "unigene pubmed list")
    private String uniprotGeneMedList;

    @Schema(description = "pdb pubmed num")
    private Integer pdbidMedN;

    @Schema(description = "pdb pubmed list")
    private String pdbidMedList;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
