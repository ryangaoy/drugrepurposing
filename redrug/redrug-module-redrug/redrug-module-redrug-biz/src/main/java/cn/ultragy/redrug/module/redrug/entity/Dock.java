package cn.ultragy.redrug.module.redrug.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "result_drugbank")
public class Dock {
    @Id
    private ObjectId _id;
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
