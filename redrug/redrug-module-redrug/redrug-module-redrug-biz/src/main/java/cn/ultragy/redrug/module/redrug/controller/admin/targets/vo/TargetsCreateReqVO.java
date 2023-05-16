package cn.ultragy.redrug.module.redrug.controller.admin.targets.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 靶点pdb创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TargetsCreateReqVO extends TargetsBaseVO {

}
