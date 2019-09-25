package com.wuzhenpay.model.response;

import java.io.Serializable;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午2:22
 * Contact  519199662@qq.com
 */

public class BaseResp implements Serializable
{
	private static final long serialVersionUID = 4165783550525503672L;
	private String merchantId;
    private String signType;
    private String charset;
    private String timestamp;
    private String format;
    private String sign;

    public String getMerchantId()
    {
        return merchantId;
    }

    public void setMerchantId(String merchantId)
    {
        this.merchantId = merchantId;
    }

    public String getSignType()
    {
        return signType;
    }

    public void setSignType(String signType)
    {
        this.signType = signType;
    }

    public String getCharset()
    {
        return charset;
    }

    public void setCharset(String charset)
    {
        this.charset = charset;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getFormat()
    {
        return format;
    }

    public void setFormat(String format)
    {
        this.format = format;
    }

    public String getSign()
    {
        return sign;
    }

    public void setSign(String sign)
    {
        this.sign = sign;
    }
}
