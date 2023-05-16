package cn.ultragy.redrug.module.redrug.service.message;

import cn.ultragy.redrug.framework.test.core.ut.BaseDbUnitTest;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageUpdateReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.message.MessageDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.message.MessageMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.ultragy.redrug.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.ultragy.redrug.framework.test.core.util.RandomUtils.randomPojo;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.MESSAGE_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
* {@link MessageServiceImpl} 的单元测试类
*
* @author ReDrug
*/
@Import(MessageServiceImpl.class)
public class MessageServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MessageServiceImpl messageService;

    @Resource
    private MessageMapper messageMapper;

    @Test
    public void testCreateMessage_success() {
        // 准备参数
        MessageCreateReqVO reqVO = randomPojo(MessageCreateReqVO.class);

        // 调用
        Integer messageId = messageService.createMessage(reqVO);
        // 断言
        assertNotNull(messageId);
        // 校验记录的属性是否正确
        MessageDO message = messageMapper.selectById(messageId);
        assertPojoEquals(reqVO, message);
    }

    @Test
    public void testUpdateMessage_success() {
        // mock 数据
        MessageDO dbMessage = randomPojo(MessageDO.class);
        messageMapper.insert(dbMessage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MessageUpdateReqVO reqVO = randomPojo(MessageUpdateReqVO.class, o -> {
            o.setId(dbMessage.getId()); // 设置更新的 ID
        });

        // 调用
        messageService.updateMessage(reqVO);
        // 校验是否更新正确
        MessageDO message = messageMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, message);
    }

    @Test
    public void testUpdateMessage_notExists() {
        // 准备参数
        MessageUpdateReqVO reqVO = randomPojo(MessageUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> messageService.updateMessage(reqVO), MESSAGE_NOT_EXISTS);
    }

    @Test
    public void testDeleteMessage_success() {
        // mock 数据
        MessageDO dbMessage = randomPojo(MessageDO.class);
        messageMapper.insert(dbMessage);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Integer id = dbMessage.getId();

        // 调用
        messageService.deleteMessage(id);
       // 校验数据不存在了
       assertNull(messageMapper.selectById(id));
    }



}
