package cn.ultragy.redrug.module.redrug.controller.admin.ipadiseaseall.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - ipa预测适应症all创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IpaDiseaseAllCreateReqVO extends IpaDiseaseAllBaseVO {

}
