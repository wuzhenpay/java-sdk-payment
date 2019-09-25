package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:54
 * Contact  519199662@qq.com
 */

public class WzpRefundQueryRequest extends WzpBaseRequest
{

    public WzpRefundQueryRequest setOutRefundNo(String outRefundNo)
    {
        param.put("outRefundNo", outRefundNo);
        return this;
    }
}
