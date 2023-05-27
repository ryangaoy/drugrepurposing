package cn.ultragy.redrug.module.redrug.dal.dataobject.message;

import cn.ultragy.redrug.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * 用户消息 DO
 *
 * @author ReDrug
 */
@TableName("redrug_message")
@KeySequence("redrug_message_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDO extends BaseDO {

    /**
     * id
     */
    @TableId
    private Integer id;
    /**
     * name
     */
    private String name;
    /**
     * email
     */
    private String email;
    /**
     * phone
     */
    private String phone;
    /**
     * message
     */
    private String message;

}
