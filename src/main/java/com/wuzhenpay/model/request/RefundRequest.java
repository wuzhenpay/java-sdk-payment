package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:54
 * Contact  519199662@qq.com
 */

public class RefundRequest extends BaseRequest
{
    public RefundRequest setOutTradeNo(String outTradeNo)
    {
        param.put("outTradeNo", outTradeNo);
        return this;
    }


    public RefundRequest setPayNo(String payNo)
    {
        param.put("payNo", payNo);
        return this;
    }

    public RefundRequest setOutRefundNo(String outRefundNo)
    {
        param.put("outRefundNo", outRefundNo);
        return this;
    }

    public RefundRequest setRefundFee(long refundFee)
    {
        param.put("refundFee", String.valueOf(refundFee));
        return this;
    }
}
