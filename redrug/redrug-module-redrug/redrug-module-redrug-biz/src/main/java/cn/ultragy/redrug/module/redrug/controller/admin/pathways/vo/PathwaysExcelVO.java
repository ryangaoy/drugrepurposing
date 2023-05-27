package cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基因通路 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class PathwaysExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("drugbank id")
    private String drugbankId;

    @ExcelProperty("名称")
    private String generalName;

    @ExcelProperty("常用叫法")
    private String knownAs;

    @ExcelProperty("passway id")
    private String passwayId;

    @ExcelProperty("描述")
    private String pathwayDesc;

    @ExcelProperty("错误率")
    private String falseDiscoveryRate;

    @ExcelProperty("标签")
    private String labels;

    @ExcelProperty("标签id")
    private String labelsIds;

    @ExcelProperty("pdbids")
    private String pdbids;

    @ExcelProperty("pdbids_list")
    private String pdbidsList;

    @ExcelProperty("pdbid_all")
    private String pdbidAll;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
