package cn.ultragy.redrug.module.pay.convert.channel;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.channel.PayChannelCreateReqVO;
import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.channel.PayChannelExcelVO;
import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.channel.PayChannelRespVO;
import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.channel.PayChannelUpdateReqVO;
import cn.ultragy.redrug.module.pay.dal.dataobject.merchant.PayChannelDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayChannelConvert {

    PayChannelConvert INSTANCE = Mappers.getMapper(PayChannelConvert.class);

    @Mapping(target = "config",ignore = true)
    PayChannelDO convert(PayChannelCreateReqVO bean);

    @Mapping(target = "config",ignore = true)
    PayChannelDO convert(PayChannelUpdateReqVO bean);

    @Mapping(target = "config",expression = "java(cn.ultragy.redrug.framework.common.util.json.JsonUtils.toJsonString(bean.getConfig()))")
    PayChannelRespVO convert(PayChannelDO bean);

    List<PayChannelRespVO> convertList(List<PayChannelDO> list);

    PageResult<PayChannelRespVO> convertPage(PageResult<PayChannelDO> page);

    List<PayChannelExcelVO> convertList02(List<PayChannelDO> list);



}
