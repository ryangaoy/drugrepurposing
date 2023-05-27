package cn.ultragy.redrug.module.redrug.convert.message;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.*;
import cn.ultragy.redrug.module.redrug.dal.dataobject.message.MessageDO;

/**
 * 用户消息 Convert
 *
 * @author ReDrug
 */
@Mapper
public interface MessageConvert {

    MessageConvert INSTANCE = Mappers.getMapper(MessageConvert.class);

    MessageDO convert(MessageCreateReqVO bean);

    MessageDO convert(MessageUpdateReqVO bean);

    MessageRespVO convert(MessageDO bean);

    List<MessageRespVO> convertList(List<MessageDO> list);

    PageResult<MessageRespVO> convertPage(PageResult<MessageDO> page);

    List<MessageExcelVO> convertList02(List<MessageDO> list);

}
