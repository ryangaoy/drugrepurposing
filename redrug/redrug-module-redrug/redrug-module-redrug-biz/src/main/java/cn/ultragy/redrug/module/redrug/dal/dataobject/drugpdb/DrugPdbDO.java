package cn.ultragy.redrug.module.redrug.dal.dataobject.drugpdb;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * drug_pdb DO
 *
 * @author 芋道源码
 */
@TableName("redrug_drug_pdb")
@KeySequence("redrug_drug_pdb_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugPdbDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * drugbankid
     */
    private String drugbankId;
    /**
     * PDBID
     */
    private String pdbId;
    /**
     * 打分
     */
    private String score;
    /**
     * 结合效率
     */
    private String bindingRate;

}
