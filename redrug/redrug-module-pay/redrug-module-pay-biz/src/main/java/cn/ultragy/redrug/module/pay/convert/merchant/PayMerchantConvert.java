package cn.ultragy.redrug.module.pay.convert.merchant;

import java.util.*;

import cn.ultragy.redrug.framework.common.pojo.PageResult;

import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.merchant.PayMerchantCreateReqVO;
import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.merchant.PayMerchantExcelVO;
import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.merchant.PayMerchantRespVO;
import cn.ultragy.redrug.module.pay.controller.admin.merchant.vo.merchant.PayMerchantUpdateReqVO;
import cn.ultragy.redrug.module.pay.dal.dataobject.merchant.PayMerchantDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PayMerchantConvert {

    PayMerchantConvert INSTANCE = Mappers.getMapper(PayMerchantConvert.class);

    PayMerchantDO convert(PayMerchantCreateReqVO bean);

    PayMerchantDO convert(PayMerchantUpdateReqVO bean);

    PayMerchantRespVO convert(PayMerchantDO bean);

    List<PayMerchantRespVO> convertList(List<PayMerchantDO> list);

    PageResult<PayMerchantRespVO> convertPage(PageResult<PayMerchantDO> page);

    List<PayMerchantExcelVO> convertList02(List<PayMerchantDO> list);

}
