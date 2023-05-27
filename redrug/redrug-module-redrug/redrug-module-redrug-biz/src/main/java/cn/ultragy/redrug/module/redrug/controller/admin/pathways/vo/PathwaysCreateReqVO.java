package cn.ultragy.redrug.module.redrug.controller.admin.pathways.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 基因通路创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PathwaysCreateReqVO extends PathwaysBaseVO {

}
