package cn.ultragy.redrug.module.redrug.dal.dataobject.ipadiseasesingle;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * ipa预测适应症single DO
 *
 * @author 芋道源码
 */
@TableName("redrug_ipa_disease_single")
@KeySequence("redrug_ipa_disease_single_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IpaDiseaseSingleDO extends BaseDO {

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
     * 基因
     */
    private String gene;
    /**
     * 功能
     */
    private String dfunction;
    /**
     * 适应症
     */
    private String disease;

}
