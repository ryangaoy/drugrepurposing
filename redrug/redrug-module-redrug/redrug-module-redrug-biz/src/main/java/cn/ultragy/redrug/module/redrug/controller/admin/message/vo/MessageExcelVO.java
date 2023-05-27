package cn.ultragy.redrug.module.redrug.controller.admin.message.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户消息 Excel VO
 *
 * @author ReDrug
 */
@Data
public class MessageExcelVO {

    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("name")
    private String name;

    @ExcelProperty("email")
    private String email;

    @ExcelProperty("phone")
    private String phone;

    @ExcelProperty("message")
    private String message;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
