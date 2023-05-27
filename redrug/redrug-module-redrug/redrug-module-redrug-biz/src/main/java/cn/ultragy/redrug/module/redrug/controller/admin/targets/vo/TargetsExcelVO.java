package cn.ultragy.redrug.module.redrug.controller.admin.targets.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 靶点pdb Excel VO
 *
 * @author 芋道源码
 */
@Data
public class TargetsExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("pdb")
    private String pdb;

    @ExcelProperty("uniprotid")
    private String uniprotId;

    @ExcelProperty("基因")
    private String geneNames;

    @ExcelProperty("物种")
    private String organism;

    @ExcelProperty("蛋白质")
    private String proteinNames;

    @ExcelProperty("大小")
    private String lengths;

    @ExcelProperty("ec")
    private String ecNumber;

    @ExcelProperty("功能")
    private String functions;

    @ExcelProperty("pubmedid")
    private String pubmedId;

    @ExcelProperty("entry")
    private String entrys;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
