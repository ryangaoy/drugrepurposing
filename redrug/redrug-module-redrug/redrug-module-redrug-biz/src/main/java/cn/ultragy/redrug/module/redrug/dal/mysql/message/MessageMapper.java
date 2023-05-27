package cn.ultragy.redrug.module.redrug.dal.mysql.message;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessageExportReqVO;
import cn.ultragy.redrug.module.redrug.controller.admin.message.vo.MessagePageReqVO;
import cn.ultragy.redrug.module.redrug.dal.dataobject.message.MessageDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户消息 Mapper
 *
 * @author ReDrug
 */
@Mapper
public interface MessageMapper extends BaseMapperX<MessageDO> {

    default PageResult<MessageDO> selectPage(MessagePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MessageDO>()
                .likeIfPresent(MessageDO::getName, reqVO.getName())
                .likeIfPresent(MessageDO::getEmail, reqVO.getEmail())
                .likeIfPresent(MessageDO::getPhone, reqVO.getPhone())
                .likeIfPresent(MessageDO::getMessage, reqVO.getMessage())
                .betweenIfPresent(MessageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MessageDO::getId));
    }

    default List<MessageDO> selectList(MessageExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MessageDO>()
                .likeIfPresent(MessageDO::getName, reqVO.getName())
                .likeIfPresent(MessageDO::getEmail, reqVO.getEmail())
                .likeIfPresent(MessageDO::getPhone, reqVO.getPhone())
                .likeIfPresent(MessageDO::getMessage, reqVO.getMessage())
                .betweenIfPresent(MessageDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MessageDO::getId));
    }

}
