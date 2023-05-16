package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseasesingle.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * ipa预测适应症single Excel VO
 *
 * @author 芋道源码
 */
@Data
public class IpaDiseaseSingleExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("drugbank id")
    private String drugbankId;

    @ExcelProperty("基因")
    private String gene;

    @ExcelProperty("功能")
    private String dfunction;

    @ExcelProperty("适应症")
    private String disease;

}
