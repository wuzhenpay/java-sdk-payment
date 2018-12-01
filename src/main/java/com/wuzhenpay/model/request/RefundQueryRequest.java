package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:54
 * Contact  519199662@qq.com
 */

public class RefundQueryRequest extends BaseRequest
{

    public RefundQueryRequest setOutRefundNo(String outRefundNo)
    {
        param.put("outRefundNo", outRefundNo);
        return this;
    }
}
