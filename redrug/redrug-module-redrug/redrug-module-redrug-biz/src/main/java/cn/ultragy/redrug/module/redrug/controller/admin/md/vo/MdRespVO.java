package cn.ultragy.redrug.module.redrug.controller.admin.md.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 分子动力学模拟结果列 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MdRespVO extends MdBaseVO {

    @Schema(description = "id", required = true, example = "3110")
    private Integer id;

}
