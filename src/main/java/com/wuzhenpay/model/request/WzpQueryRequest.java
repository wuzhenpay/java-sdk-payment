package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:54
 * Contact  519199662@qq.com
 */

public class WzpQueryRequest extends WzpBaseRequest
{
    public WzpQueryRequest setOutTradeNo(String outTradeNo)
    {
        param.put("outTradeNo", outTradeNo);
        return this;
    }


    public WzpQueryRequest setPayNo(String payNo)
    {
        param.put("payNo", payNo);
        return this;
    }
}
