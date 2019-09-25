package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午4:48
 * Contact  519199662@qq.com
 */

public class WzpCloseReverseRequest extends WzpBaseRequest
{
    public WzpCloseReverseRequest setOutTradeNo(String outTradeNo)
    {
        param.put("outTradeNo", outTradeNo);
        return this;
    }
}
