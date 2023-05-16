package cn.ultragy.redrug.module.redrug.dal.dataobject.pathways;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 基因通路 DO
 *
 * @author 芋道源码
 */
@TableName("redrug_pathways")
@KeySequence("redrug_pathways_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PathwaysDO extends BaseDO {

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
     * 名称
     */
    private String generalName;
    /**
     * 常用叫法
     */
    private String knownAs;
    /**
     * passway id
     */
    private String passwayId;
    /**
     * 描述
     */
    private String pathwayDesc;
    /**
     * 错误率
     */
    private String falseDiscoveryRate;
    /**
     * 标签
     */
    private String labels;
    /**
     * 标签id
     */
    private String labelsIds;
    /**
     * pdbids
     */
    private String pdbids;
    /**
     * pdbids_list
     */
    private String pdbidsList;
    /**
     * pdbid_all
     */
    private String pdbidAll;

}
