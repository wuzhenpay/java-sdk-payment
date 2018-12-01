package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午4:48
 * Contact  519199662@qq.com
 */

public class CloseReverseRequest extends BaseRequest
{
    public CloseReverseRequest setOutTradeNo(String outTradeNo)
    {
        param.put("outTradeNo", outTradeNo);
        return this;
    }
}
