package cn.ultragy.redrug.module.redrug.dal.dataobject.screen;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 筛选结果 DO
 *
 * @author 芋道源码
 */
@TableName("redrug_screen")
@KeySequence("redrug_screen_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScreenDO extends BaseDO {

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
     * uniprot id
     */
    private String uniprotId;
    /**
     * tg name
     */
    private String tgname;
    /**
     * pdb
     */
    private String pdbid;
    /**
     * score
     */
    private Double score;
    /**
     * 结合效率
     */
    private Double bindingRate;
    /**
     * tgname pubmed num
     */
    private String uniprotTgnameMedN;
    /**
     * tgname pubmed list
     */
    private String uniprotTgnameMedList;
    /**
     * tgshort pubmed num
     */
    private Integer uniprotTgshortMedN;
    /**
     * tgshort pubmed list
     */
    private String uniprotTgshortMedList;
    /**
     * alname pubmed num
     */
    private Integer alternativeNameMedN;
    /**
     * alname pubmed list
     */
    private String alternativeNameMedList;
    /**
     * unidisease pubmed num
     */
    private Integer uniprotDiseaseMedN;
    /**
     * unidisease pubmed list
     */
    private String uniprotDiseaseMedList;
    /**
     * unigene pubmed num
     */
    private Integer uniprotGeneMedN;
    /**
     * unigene pubmed list
     */
    private String uniprotGeneMedList;
    /**
     * pdb pubmed num
     */
    private Integer pdbidMedN;
    /**
     * pdb pubmed list
     */
    private String pdbidMedList;

}
