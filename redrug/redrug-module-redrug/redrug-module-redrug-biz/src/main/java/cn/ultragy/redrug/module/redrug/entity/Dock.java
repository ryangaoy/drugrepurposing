package cn.ultragy.redrug.module.redrug.entity;

import lombok.Data;

@Data
public class Dock {
    private String result_id;
    private String target_id;
    private String ligand_id;
    private String data_path;
    private Integer score;
    private String result_content;
    private String ligand_dataset;
    private String protein_dataset;
    private String create_time;
}
