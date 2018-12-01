package com.wuzhenpay.model.response;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:50
 * Contact  519199662@qq.com
 */

public class PayInfo
{
    private String codeUrl;

    private String timeStamp;

    private String paySign;

    private String appId;

    private String signType;

    private String packages;

    private String nonceStr;

    public String getCodeUrl()
    {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl)
    {
        this.codeUrl = codeUrl;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public String getPaySign()
    {
        return paySign;
    }

    public void setPaySign(String paySign)
    {
        this.paySign = paySign;
    }

    public String getAppId()
    {
        return appId;
    }

    public void setAppId(String appId)
    {
        this.appId = appId;
    }

    public String getSignType()
    {
        return signType;
    }

    public void setSignType(String signType)
    {
        this.signType = signType;
    }

    public String getPackages()
    {
        return packages;
    }

    public void setPackages(String packages)
    {
        this.packages = packages;
    }

    public String getNonceStr()
    {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr)
    {
        this.nonceStr = nonceStr;
    }
}
