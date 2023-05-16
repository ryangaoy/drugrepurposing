package cn.ultragy.redrug.module.redrug.controller.admin.drugpdb.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Schema(description = "管理后台 - drug_pdb Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class DrugPdbRespVO extends DrugPdbBaseVO {

    @Schema(description = "id", required = true, example = "15003")
    private Integer id;

}
