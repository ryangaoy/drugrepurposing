package cn.ultragy.redrug.module.redrug.dal.dataobject.targets;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 靶点pdb DO
 *
 * @author 芋道源码
 */
@TableName("redrug_targets")
@KeySequence("redrug_targets_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TargetsDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * pdb
     */
    private String pdb;
    /**
     * uniprotid
     */
    private String uniprotId;
    /**
     * 基因
     */
    private String geneNames;
    /**
     * 物种
     */
    private String organism;
    /**
     * 蛋白质
     */
    private String proteinNames;
    /**
     * 大小
     */
    private String lengths;
    /**
     * ec
     */
    private String ecNumber;
    /**
     * 功能
     */
    private String functions;
    /**
     * pubmedid
     */
    private String pubmedId;
    /**
     * entry
     */
    private String entrys;

}
