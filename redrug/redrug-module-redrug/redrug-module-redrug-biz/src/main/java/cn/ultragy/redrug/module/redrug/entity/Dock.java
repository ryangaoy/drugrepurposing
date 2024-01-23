package cn.ultragy.redrug.module.redrug.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "result_drugbank")
public class Dock {
    @Id
    private ObjectId _id;
    private String target_id;
    private String ligand_id;
    private Integer score;
    private Integer non_h_atoms;
    private Double rate_combination;
}
