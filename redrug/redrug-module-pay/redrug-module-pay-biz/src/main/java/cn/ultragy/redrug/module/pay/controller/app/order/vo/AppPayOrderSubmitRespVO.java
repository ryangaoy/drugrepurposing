package cn.ultragy.redrug.module.pay.controller.app.order.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Schema(description = "用户 APP - 支付订单提交 Response VO")
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppPayOrderSubmitRespVO {

    /**
     * 调用支付渠道的响应结果
     */
    private Object invokeResponse;

}
