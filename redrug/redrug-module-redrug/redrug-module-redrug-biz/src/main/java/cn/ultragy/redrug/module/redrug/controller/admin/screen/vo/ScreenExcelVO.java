package cn.ultragy.redrug.module.redrug.controller.admin.screen.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 筛选结果 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ScreenExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("drugbank id")
    private String drugbankId;

    @ExcelProperty("uniprot id")
    private String uniprotId;

    @ExcelProperty("tg name")
    private String tgname;

    @ExcelProperty("pdb")
    private String pdbid;

    @ExcelProperty("score")
    private Double score;

    @ExcelProperty("结合效率")
    private Double bindingRate;

    @ExcelProperty("tgname pubmed num")
    private String uniprotTgnameMedN;

    @ExcelProperty("tgname pubmed list")
    private String uniprotTgnameMedList;

    @ExcelProperty("tgshort pubmed num")
    private Integer uniprotTgshortMedN;

    @ExcelProperty("tgshort pubmed list")
    private String uniprotTgshortMedList;

    @ExcelProperty("alname pubmed num")
    private Integer alternativeNameMedN;

    @ExcelProperty("alname pubmed list")
    private String alternativeNameMedList;

    @ExcelProperty("unidisease pubmed num")
    private Integer uniprotDiseaseMedN;

    @ExcelProperty("unidisease pubmed list")
    private String uniprotDiseaseMedList;

    @ExcelProperty("unigene pubmed num")
    private Integer uniprotGeneMedN;

    @ExcelProperty("unigene pubmed list")
    private String uniprotGeneMedList;

    @ExcelProperty("pdb pubmed num")
    private Integer pdbidMedN;

    @ExcelProperty("pdb pubmed list")
    private String pdbidMedList;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
