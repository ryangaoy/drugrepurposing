package cn.ultragy.redrug.module.redrug.controller.admin.message.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Schema(description = "管理后台 - 用户消息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MessageUpdateReqVO extends MessageBaseVO {

    @Schema(description = "id", required = true, example = "12039")
    @NotNull(message = "id不能为空")
    private Integer id;

}
