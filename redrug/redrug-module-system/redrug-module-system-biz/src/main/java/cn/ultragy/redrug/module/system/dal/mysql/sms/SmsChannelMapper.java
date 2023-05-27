package cn.ultragy.redrug.module.system.dal.mysql.sms;

import cn.ultragy.redrug.framework.common.pojo.PageResult;
import cn.ultragy.redrug.framework.mybatis.core.mapper.BaseMapperX;
import cn.ultragy.redrug.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.ultragy.redrug.module.system.controller.admin.sms.vo.channel.SmsChannelPageReqVO;
import cn.ultragy.redrug.module.system.dal.dataobject.sms.SmsChannelDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SmsChannelMapper extends BaseMapperX<SmsChannelDO> {

    default PageResult<SmsChannelDO> selectPage(SmsChannelPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<SmsChannelDO>()
                .likeIfPresent(SmsChannelDO::getSignature, reqVO.getSignature())
                .eqIfPresent(SmsChannelDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(SmsChannelDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(SmsChannelDO::getId));
    }

}
