package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:54
 * Contact  519199662@qq.com
 */

public class QueryRequest extends BaseRequest
{
    public QueryRequest setOutTradeNo(String outTradeNo)
    {
        param.put("outTradeNo", outTradeNo);
        return this;
    }


    public QueryRequest setPayNo(String payNo)
    {
        param.put("payNo", payNo);
        return this;
    }
}
