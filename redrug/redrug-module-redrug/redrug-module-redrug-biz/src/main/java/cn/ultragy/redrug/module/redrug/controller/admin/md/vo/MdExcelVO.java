package cn.ultragy.redrug.module.redrug.controller.admin.md.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 分子动力学模拟结果列 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class MdExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("drugbank id")
    private String drugbankId;

    @ExcelProperty("entry")
    private String entrys;

    @ExcelProperty("蛋白质")
    private String proteinNames;

    @ExcelProperty("pdb id")
    private String pdb;

    @ExcelProperty("uniprotid")
    private String uniprotId;

    @ExcelProperty("物种")
    private String organism;

    @ExcelProperty("大小")
    private Integer lengths;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
