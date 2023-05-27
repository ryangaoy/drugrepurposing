package cn.ultragy.redrug.module.redrug.dal.dataobject.drugs;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 药物信息 DO
 *
 * @author 芋道源码
 */
@TableName("redrug_drugs")
@KeySequence("redrug_drugs_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DrugsDO extends BaseDO {

    /**
     * ID
     */
    @TableId(type = IdType.INPUT)
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
     * 分类
     */
    private String groups;
    /**
     * 分子式
     */
    private String molecular;
    /**
     * 重原子数
     */
    private String atomicN;
    /**
     * 结构
     */
    private String structure;
    /**
     * 制造商
     */
    private String manufacturers;
    /**
     * 适应症
     */
    private String indication;
    /**
     * 靶点
     */
    private String targets;
    /**
     * Uniprot ID
     */
    private String uniprotId;
}
