package cn.ultragy.redrug.module.redrug.dal.dataobject.screendrugs;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 筛选药物 DO
 *
 * @author 芋道源码
 */
@TableName("redrug_screen_drugs")
@KeySequence("redrug_screen_drugs_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDrugsDO extends BaseDO {

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
     * name
     */
    private String name;
    /**
     * desc
     */
    private String description;
    /**
     * cas
     */
    private String casNumber;
    /**
     * amass
     */
    private Double averageMass;
    /**
     * mmass
     */
    private Double monoisotopicMass;
    /**
     * group
     */
    private String groups;
    /**
     * ref
     */
    private String synthesisReference;
    /**
     * indi
     */
    private String indication;
    /**
     * phar
     */
    private String pharmacodynamics;
    /**
     * absor
     */
    private String absorption;
    /**
     * vod
     */
    private String volumeOfDistribution;
    /**
     * probinding
     */
    private String proteinBinding;
    /**
     * meta
     */
    private String metabolism;
    /**
     * route
     */
    private String routeOfElimination;
    /**
     * h life
     */
    private String halfLife;
    /**
     * clear
     */
    private String clearance;
    /**
     * mol
     */
    private String molecular;
    /**
     * atomic num
     */
    private Short atomicN;
    /**
     * manu
     */
    private String manufacturers;
    /**
     * gene
     */
    private String pubmedGene;

}
