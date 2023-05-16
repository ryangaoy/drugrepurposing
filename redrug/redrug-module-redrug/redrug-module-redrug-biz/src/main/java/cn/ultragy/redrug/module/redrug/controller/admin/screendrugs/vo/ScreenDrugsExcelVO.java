package cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 筛选药物 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class ScreenDrugsExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("drugbank id")
    private String drugbankId;

    @ExcelProperty("name")
    private String name;

    @ExcelProperty("desc")
    private String description;

    @ExcelProperty("cas")
    private String casNumber;

    @ExcelProperty("amass")
    private Double averageMass;

    @ExcelProperty("mmass")
    private Double monoisotopicMass;

    @ExcelProperty("group")
    private String groups;

    @ExcelProperty("ref")
    private String synthesisReference;

    @ExcelProperty("indi")
    private String indication;

    @ExcelProperty("phar")
    private String pharmacodynamics;

    @ExcelProperty("absor")
    private String absorption;

    @ExcelProperty("vod")
    private String volumeOfDistribution;

    @ExcelProperty("probinding")
    private String proteinBinding;

    @ExcelProperty("meta")
    private String metabolism;

    @ExcelProperty("route")
    private String routeOfElimination;

    @ExcelProperty("h life")
    private String halfLife;

    @ExcelProperty("clear")
    private String clearance;

    @ExcelProperty("mol")
    private String molecular;

    @ExcelProperty("atomic num")
    private Short atomicN;

    @ExcelProperty("manu")
    private String manufacturers;

    @ExcelProperty("gene")
    private String pubmedGene;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
