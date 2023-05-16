package cn.ultragy.redrug.module.redrug.service.message;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageCreateReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessagePageReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageUpdateReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.message.MessageDO;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

/**
 * 用户消息 Service 接口
 *
 * @author ReDrug
 */
public interface MessageService {

    /**
     * 创建用户消息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Integer createMessage(@Valid MessageCreateReqVO createReqVO);

    /**
     * 更新用户消息
     *
     * @param updateReqVO 更新信息
     */
    void updateMessage(@Valid MessageUpdateReqVO updateReqVO);

    /**
     * 删除用户消息
     *
     * @param id 编号
     */
    void deleteMessage(Integer id);

    /**
     * 获得用户消息
     *
     * @param id 编号
     * @return 用户消息
     */
    MessageDO getMessage(Integer id);

    /**
     * 获得用户消息列表
     *
     * @param ids 编号
     * @return 用户消息列表
     */
    List<MessageDO> getMessageList(Collection<Integer> ids);

    /**
     * 获得用户消息分页
     *
     * @param pageReqVO 分页查询
     * @return 用户消息分页
     */
    PageResult<MessageDO> getMessagePage(MessagePageReqVO pageReqVO);

    /**
     * 获得用户消息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 用户消息列表
     */
    List<MessageDO> getMessageList(MessageExportReqVO exportReqVO);

}
