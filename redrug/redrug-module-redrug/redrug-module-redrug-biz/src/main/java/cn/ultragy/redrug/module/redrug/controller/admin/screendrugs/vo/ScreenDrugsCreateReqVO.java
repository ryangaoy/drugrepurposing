package cn.ultragy.redrug.module.redrug.controller.admin.screendrugs.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - 筛选药物创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ScreenDrugsCreateReqVO extends ScreenDrugsBaseVO {

}
