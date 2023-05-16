package cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * drug_pdb Excel VO
 *
 * @author 芋道源码
 */
@Data
public class DrugPdbExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("drugbankid")
    private String drugbankId;

    @ExcelProperty("PDBID")
    private String pdbId;

    @ExcelProperty("打分")
    private String score;

    @ExcelProperty("结合效率")
    private String bindingRate;

}
