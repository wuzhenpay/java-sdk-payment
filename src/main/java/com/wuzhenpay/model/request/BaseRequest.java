package com.wuzhenpay.model.request;

import com.wuzhenpay.WuzhenpayClient;
import com.wuzhenpay.utils.MD5Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午12:29
 * Contact  519199662@qq.com
 */

public class BaseRequest
{
    protected Map<String,String> param;

    public BaseRequest()
    {
        param=new HashMap<>();
        param.put("version","2.0");
        param.put("signType","md5");
        param.put("format","json");
        param.put("charset","utf-8");
        param.put("timestamp","yyyyMMddHHmmss");
        param.put("merchantId",WuzhenpayClient.merchantId);
    }

    public Map<String,String> createParam()
    {

        String sign =MD5Util.getHSign(param);
        param.put("sign",sign);
        return param;
    }
}
