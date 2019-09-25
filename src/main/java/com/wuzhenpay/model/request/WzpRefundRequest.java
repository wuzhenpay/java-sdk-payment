package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:54
 * Contact  519199662@qq.com
 */

public class WzpRefundRequest extends WzpBaseRequest
{
    public WzpRefundRequest setOutTradeNo(String outTradeNo)
    {
        param.put("outTradeNo", outTradeNo);
        return this;
    }


    public WzpRefundRequest setPayNo(String payNo)
    {
        param.put("payNo", payNo);
        return this;
    }

    public WzpRefundRequest setOutRefundNo(String outRefundNo)
    {
        param.put("outRefundNo", outRefundNo);
        return this;
    }

    public WzpRefundRequest setRefundFee(Long refundFee)
    {
        param.put("refundFee", String.valueOf(refundFee));
        return this;
    }

    public WzpRefundRequest setReason(String reason)
    {
        param.put("reason", reason);
        return this;
    }
}
