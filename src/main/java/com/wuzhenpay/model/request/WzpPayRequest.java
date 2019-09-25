package com.wuzhenpay.model.request;


import java.util.regex.Pattern;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午12:31
 * Contact  519199662@qq.com
 */

public class WzpPayRequest extends WzpBaseRequest
{

    private static final Pattern ALIPAY_AUTHCODE_PATTERN = Pattern.compile("^[2|3][5|6|7|8|9|0]\\d{14,22}$");
    private static final Pattern WECHAT_AUTHCODE_PATTERN = Pattern.compile("^1[0-5]\\d{16}$");

    //支付宝_code支付方式即商户扫用户二维码
    private WzpPayRequest alipayCode()
    {
        param.put("payType", "pay.alipay.code");
        return this;
    }

    //支付宝_native支付即用户扫商户二维码
    public WzpPayRequest alipayQrcode()
    {
        param.put("payType", "pay.alipay.native");
        return this;
    }

    //支付宝_jsapi支付即用户扫商户固态二维码
    public WzpPayRequest alipayJs()
    {
        param.put("payType", "pay.alipay.jsapi");
        return this;
    }

    private WzpPayRequest wechatCode()
    {
        param.put("payType", "pay.wechat.code");
        return this;
    }

    public WzpPayRequest wechatQrcode()
    {
        param.put("payType", "pay.wechat.native");
        return this;
    }

    public WzpPayRequest wechatJs()
    {
        param.put("payType", "pay.wechat.jsapi");
        return this;
    }

    private WzpPayRequest unionPayCode()
    {
        param.put("payType", "pay.unionpay.code");
        return this;
    }

    public WzpPayRequest unionPayQrcode()
    {
        param.put("payType", "pay.unionpay.native");
        return this;
    }

    public WzpPayRequest unionPayJs()
    {
        param.put("payType", "pay.unionpay.jsapi");
        return this;
    }

    public WzpPayRequest setOutTradeNo(String outTradeNo)
    {
        param.put("outTradeNo", outTradeNo);
        return this;
    }


    public WzpPayRequest setTitle(String title)
    {
        param.put("title", title);
        return this;
    }

    public WzpPayRequest setPayMoney(Long payMoney)
    {
        param.put("payMoney", payMoney.toString());
        return this;
    }

    public WzpPayRequest setTimeExpire(String timeExpire)
    {
        param.put("timeExpire", timeExpire);
        return this;
    }


    public WzpPayRequest setNotifyUrl(String notifyUrl)
    {
        param.put("notifyUrl", notifyUrl);
        return this;
    }

    public WzpPayRequest setSubAppid(String subAppid)
    {
        param.put("subAppid", subAppid);
        return this;
    }

    public WzpPayRequest setIsMinipg(int isMinipg)
    {
        param.put("isMinipg", String.valueOf(isMinipg));
        return this;
    }

    public WzpPayRequest setOpenid(String openid)
    {
        param.put("openid", openid);
        return this;
    }

    public WzpPayRequest setBuyerId(String buyerId)
    {
        param.put("buyerId", buyerId);
        return this;
    }

    public WzpPayRequest setAuthCode(String authCode)
    {
        param.put("authCode", authCode);
        matcherAuthCodeType(authCode);
        return this;
    }

    public WzpPayRequest setOperatorId(String operatorId)
    {
        param.put("operatorId", operatorId);
        return this;
    }

    public WzpPayRequest setTerminalId(String terminalId)
    {
        param.put("terminalId", terminalId);
        return this;
    }


    public WzpPayRequest setAttach(String attach)
    {
        param.put("attach", attach);
        return this;
    }

    public WzpPayRequest setRemarks(String remarks)
    {
        if (remarks!=null && remarks.length()>0)
        {
            param.put("remarks", remarks);
        }
        return this;
    }

    /**
     * 根据付款码设置交易的支付码是支付宝or微信
     * code支付方式时，设置支付码调用此方法
     *
     * @param authCode
     * @return
     */
    private WzpPayRequest matcherAuthCodeType(String authCode)
    {
        if (ALIPAY_AUTHCODE_PATTERN.matcher(authCode).matches())
        {
            alipayCode();
        }
        else if (WECHAT_AUTHCODE_PATTERN.matcher(authCode).matches())
        {
            wechatCode();
        }
        else
        {
            unionPayCode();
        }
        return this;
    }

}
