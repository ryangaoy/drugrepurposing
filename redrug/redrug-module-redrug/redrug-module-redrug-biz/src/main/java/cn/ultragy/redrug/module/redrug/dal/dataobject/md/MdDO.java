package cn.ultragy.redrug.module.redrug.dal.dataobject.md;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 分子动力学模拟结果列 DO
 *
 * @author 芋道源码
 */
@TableName("redrug_md")
@KeySequence("redrug_md_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MdDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * drugbank id
     */
    private String drugbankId;
    /**
     * entry
     */
    private String entrys;
    /**
     * 蛋白质
     */
    private String proteinNames;
    /**
     * pdb id
     */
    private String pdb;
    /**
     * uniprotid
     */
    private String uniprotId;
    /**
     * 物种
     */
    private String organism;
    /**
     * 大小
     */
    private Integer lengths;

}
