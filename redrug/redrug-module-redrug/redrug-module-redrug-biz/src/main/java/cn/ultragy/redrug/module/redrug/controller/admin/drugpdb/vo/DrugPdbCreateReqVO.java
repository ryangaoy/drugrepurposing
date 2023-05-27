package cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - drug_pdb创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DrugPdbCreateReqVO extends DrugPdbBaseVO {

}
