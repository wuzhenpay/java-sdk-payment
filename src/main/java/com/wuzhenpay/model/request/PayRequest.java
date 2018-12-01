package com.wuzhenpay.model.request;


import java.util.regex.Pattern;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午12:31
 * Contact  519199662@qq.com
 */

public class PayRequest extends BaseRequest
{

    private static final Pattern ALIPAY_AUTHCODE_PATTERN = Pattern.compile("^[2|3][5|6|7|8|9|0]\\d{14,22}$");
    private static final Pattern WECHAT_AUTHCODE_PATTERN = Pattern.compile("^1[0-5]\\d{16}$");

    private PayRequest alipayCode()
    {
        param.put("payType", "pay.alipay.code");
        return this;
    }

    public PayRequest alipayQrcode()
    {
        param.put("payType", "pay.alipay.qrcode");
        return this;
    }

    public PayRequest alipayJs()
    {
        param.put("payType", "pay.alipay.js");
        return this;
    }

    private PayRequest wechatCode()
    {
        param.put("payType", "pay.wechat.code");
        return this;
    }

    public PayRequest wechatQrcode()
    {
        param.put("payType", "pay.wechat.qrcode");
        return this;
    }

    public PayRequest wechatJs()
    {
        param.put("payType", "pay.wechat.js");
        return this;
    }

    public PayRequest setOutTradeNo(String outTradeNo)
    {
        param.put("outTradeNo", outTradeNo);
        return this;
    }


    public PayRequest setTitle(String title)
    {
        param.put("title", title);
        return this;
    }

    public PayRequest setPayMoney(long payMoney)
    {
        param.put("payMoney", String.valueOf(payMoney));
        return this;
    }

    public PayRequest setTimeExpire(String timeExpire)
    {
        param.put("timeExpire", timeExpire);
        return this;
    }


    public PayRequest setNotifyUrl(String notifyUrl)
    {
        param.put("notifyUrl", notifyUrl);
        return this;
    }

    public PayRequest setSubAppid(String subAppid)
    {
        param.put("subAppid", subAppid);
        return this;
    }

    public PayRequest setIsMinipg(int isMinipg)
    {
        param.put("isMinipg", String.valueOf(isMinipg));
        return this;
    }

    public PayRequest setOpenid(String openid)
    {
        param.put("openid", openid);
        return this;
    }

    public PayRequest setBuyerId(String buyerId)
    {
        param.put("buyerId", buyerId);
        return this;
    }

    public PayRequest setAuthCode(String authCode)
    {
        param.put("authCode", authCode);
        matcherAuthCodeType(authCode);
        return this;
    }

    public PayRequest setOperatorId(String operatorId)
    {
        param.put("operatorId", operatorId);
        return this;
    }

    public PayRequest setTerminalId(String terminalId)
    {
        param.put("terminalId", terminalId);
        return this;
    }

    public PayRequest setSource(String source)
    {
        param.put("source", source);
        return this;
    }

    public PayRequest setExtend(String extend)
    {
        param.put("extend", extend);
        return this;
    }

    public PayRequest setRemarks(String remarks)
    {
        param.put("remarks", remarks);
        return this;
    }


    private PayRequest matcherAuthCodeType(String authCode)
    {
        if (ALIPAY_AUTHCODE_PATTERN.matcher(authCode).matches())
        {
            alipayCode();
        }
        else if (WECHAT_AUTHCODE_PATTERN.matcher(authCode).matches())
        {
            wechatCode();
        }
        return this;
    }

}
