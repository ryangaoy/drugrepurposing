package cn.ultragy.redrug.module.pay.controller.app.refund;

import cn.hutool.core.util.StrUtil;
import cn.ultragy.redrug.framework.common.pojo.CommonResult;
import cn.ultragy.redrug.module.pay.controller.app.refund.vo.AppPayRefundReqVO;
import cn.ultragy.redrug.module.pay.controller.app.refund.vo.AppPayRefundRespVO;
import cn.ultragy.redrug.module.pay.convert.refund.PayRefundConvert;
import cn.ultragy.redrug.module.pay.service.order.dto.PayRefundReqDTO;
import cn.ultragy.redrug.module.pay.service.refund.PayRefundService;
import cn.ultragy.redrug.module.pay.util.PaySeqUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static cn.ultragy.redrug.framework.common.pojo.CommonResult.success;
import static cn.ultragy.redrug.framework.common.util.servlet.ServletUtils.getClientIP;

@Tag(name = "用户 APP - 退款订单")
@RestController
@RequestMapping("/pay/refund")
@Validated
@Slf4j
public class AppPayRefundController {

    @Resource
    private PayRefundService refundService;

    @PostMapping("/refund")
    @Operation(summary = "提交退款订单")
    public CommonResult<AppPayRefundRespVO> submitRefundOrder(@RequestBody AppPayRefundReqVO reqVO){
        PayRefundReqDTO req = PayRefundConvert.INSTANCE.convert(reqVO);
        req.setUserIp(getClientIP());
        // TODO 测试暂时模拟生成商户退款订单
        if(StrUtil.isEmpty(reqVO.getMerchantRefundId())) {
            req.setMerchantRefundId(PaySeqUtils.genMerchantRefundNo());
        }
        return success(PayRefundConvert.INSTANCE.convert(refundService.submitRefundOrder(req)));
    }

}
