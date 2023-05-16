package cn.ultragy.redrug.module.redrug.service.message;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessagePageReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageUpdateReqVO;
import cn.ultragy.redrug.module.redrug.convert.message.MessageConvert;
import cn.ultragy.redrug.module.redrug.dal.dataobject.message.MessageDO;
import cn.ultragy.redrug.module.redrug.dal.mysql.message.MessageMapper;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static cn.ultragy.redrug.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.ultragy.redrug.module.redrug.enums.ErrorCodeConstants.MESSAGE_NOT_EXISTS;

/**
 * 用户消息 Service 实现类
 *
 * @author ReDrug
 */
@Service
@Validated
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public Integer createMessage(MessageCreateReqVO createReqVO) {
        // 插入
        MessageDO message = MessageConvert.INSTANCE.convert(createReqVO);
        messageMapper.insert(message);
        // 返回
        return message.getId();
    }

    @Override
    public void updateMessage(MessageUpdateReqVO updateReqVO) {
        // 校验存在
        validateMessageExists(updateReqVO.getId());
        // 更新
        MessageDO updateObj = MessageConvert.INSTANCE.convert(updateReqVO);
        messageMapper.updateById(updateObj);
    }

    @Override
    public void deleteMessage(Integer id) {
        // 校验存在
        validateMessageExists(id);
        // 删除
        messageMapper.deleteById(id);
    }

    private void validateMessageExists(Integer id) {
        if (messageMapper.selectById(id) == null) {
            throw exception(MESSAGE_NOT_EXISTS);
        }
    }

    @Override
    public MessageDO getMessage(Integer id) {
        return messageMapper.selectById(id);
    }

    @Override
    public List<MessageDO> getMessageList(Collection<Integer> ids) {
        return messageMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MessageDO> getMessagePage(MessagePageReqVO pageReqVO) {
        return messageMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MessageDO> getMessageList(MessageExportReqVO exportReqVO) {
        return messageMapper.selectList(exportReqVO);
    }

}
