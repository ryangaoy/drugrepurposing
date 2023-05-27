package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ipa预测适应症all Excel VO
 *
 * @author 芋道源码
 */
@Data
public class IpaDiseaseAllExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("drugbank id")
    private String drugbankId;

    @ExcelProperty("来源")
    private String fromM;

    @ExcelProperty("类型")
    private String typeM;

    @ExcelProperty("目标")
    private String toM;

    @ExcelProperty("catalyst")
    private String catalyst;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
