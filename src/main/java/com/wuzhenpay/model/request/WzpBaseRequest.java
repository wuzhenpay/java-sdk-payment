package com.wuzhenpay.model.request;

import com.wuzhenpay.utils.DateUtil;
import com.wuzhenpay.utils.MD5Util;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午12:29
 * Contact  519199662@qq.com
 */

public class WzpBaseRequest
{
    protected TreeMap<String, String> param;

    public WzpBaseRequest()
    {

        param = new TreeMap<>();
        param.put("version", "3.0");
        param.put("timestamp", DateUtil.parseDateToStr(new Date(), DateUtil.DATE_TIME_FORMAT_YYYYMMDDHHMISS));
        param.put("signType", "md5");
        param.put("charset", "utf-8");
        param.put("format", "json");
    }

    public Map<String, String> createParam(String merchantId, String secret)
    {
        param.put("merchantId", merchantId);
        String sign = MD5Util.sign(param, secret);
        param.put("sign", sign);
        return param;
    }
}
