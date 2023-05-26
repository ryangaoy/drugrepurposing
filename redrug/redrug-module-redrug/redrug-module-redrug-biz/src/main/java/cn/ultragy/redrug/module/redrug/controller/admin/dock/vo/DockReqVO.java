package cn.ultragy.redrug.module.redrug.controller.admin.dock.vo;

import cn.ultragy.redrug.framework.common.pojo.PageParam;
import lombok.Data;

@Data
public class DockReqVO extends PageParam {
    private String target_id;
    private String ligand_id;
    private Integer score;
    private String ligand_dataset;
    private String protein_dataset;
}
