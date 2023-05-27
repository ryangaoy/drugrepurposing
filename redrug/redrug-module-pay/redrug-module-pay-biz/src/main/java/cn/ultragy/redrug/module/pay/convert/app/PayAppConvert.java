package cn.ultragy.redrug.module.pay.convert.app;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.app.*;
import cn.ultragy.redrug.module.pay.dal.dataobject.merchant.PayAppDO;
import cn.ultragy.redrug.module.pay.dal.dataobject.merchant.PayMerchantDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 支付应用信息 Convert
 *
 * @author 芋艿
 */
@Mapper
public interface PayAppConvert {

    PayAppConvert INSTANCE = Mappers.getMapper(PayAppConvert.class);

    PayAppPageItemRespVO pageConvert (PayAppDO bean);

    PayAppPageItemRespVO.PayMerchant convert(PayMerchantDO bean);

    PayAppDO convert(PayAppCreateReqVO bean);

    PayAppDO convert(PayAppUpdateReqVO bean);

    PayAppRespVO convert(PayAppDO bean);

    List<PayAppRespVO> convertList(List<PayAppDO> list);

    PageResult<PayAppRespVO> convertPage(PageResult<PayAppDO> page);

    List<PayAppExcelVO> convertList02(List<PayAppDO> list);

}
