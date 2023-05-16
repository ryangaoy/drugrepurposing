package cn.ultragy.redrug.module.redrug.controller.admin.drugs.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 药物信息 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DrugsExcelVO {

    @ExcelProperty("ID")
    private String drugbankId;

    @ExcelProperty("名称")
    private String generalName;

    @ExcelProperty("常用叫法")
    private String knownAs;

    @ExcelProperty("分类")
    private String groups;

    @ExcelProperty("分子式")
    private String molecular;

    @ExcelProperty("重原子数")
    private String atomicN;

    @ExcelProperty("结构")
    private String structure;

    @ExcelProperty("制造商")
    private String manufacturers;

    @ExcelProperty("适应症")
    private String indication;

    @ExcelProperty("靶点")
    private String targets;

    @ExcelProperty("Uniprot ID")
    private String uniprotId;

}
