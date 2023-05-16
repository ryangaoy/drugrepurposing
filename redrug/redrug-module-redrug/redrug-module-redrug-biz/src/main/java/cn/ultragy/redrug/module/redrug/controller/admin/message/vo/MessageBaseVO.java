package cn.ultragy.redrug.module.redrug.controller.admin.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* 用户消息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MessageBaseVO {

    @Schema(description = "name", example = "王五")
    private String name;

    @Schema(description = "email")
    private String email;

    @Schema(description = "phone")
    private String phone;

    @Schema(description = "message")
    private String message;

}
