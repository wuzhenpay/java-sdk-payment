package com.wuzhenpay.model.response;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:22
 * Contact  519199662@qq.com
 */

public class PayResp extends BaseResponse
{
    private String status;
    private String statusMsg;
    private String payNo;
    private String outTradeNo;
    private String thirdTradeNo;
    private String payChannelTradeNo;
    private Long payMoney;
    private String payType;
    private String payTime;
    private String feeType;
    private String bankType;
    private String appid;
    private String subAppid;
    private String openid;
    private String subOpenid;
    private String buyerLogonId;
    private String buyerUserId;
    private String extend;
    private PayInfo payInfo;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatusMsg()
    {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg)
    {
        this.statusMsg = statusMsg;
    }

    public String getPayNo()
    {
        return payNo;
    }

    public void setPayNo(String payNo)
    {
        this.payNo = payNo;
    }

    public String getOutTradeNo()
    {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo)
    {
        this.outTradeNo = outTradeNo;
    }

    public String getThirdTradeNo()
    {
        return thirdTradeNo;
    }

    public void setThirdTradeNo(String thirdTradeNo)
    {
        this.thirdTradeNo = thirdTradeNo;
    }

    public String getPayChannelTradeNo()
    {
        return payChannelTradeNo;
    }

    public void setPayChannelTradeNo(String payChannelTradeNo)
    {
        this.payChannelTradeNo = payChannelTradeNo;
    }

    public Long getPayMoney()
    {
        return payMoney;
    }

    public void setPayMoney(Long payMoney)
    {
        this.payMoney = payMoney;
    }

    public String getPayType()
    {
        return payType;
    }

    public void setPayType(String payType)
    {
        this.payType = payType;
    }

    public String getPayTime()
    {
        return payTime;
    }

    public void setPayTime(String payTime)
    {
        this.payTime = payTime;
    }

    public String getFeeType()
    {
        return feeType;
    }

    public void setFeeType(String feeType)
    {
        this.feeType = feeType;
    }

    public String getBankType()
    {
        return bankType;
    }

    public void setBankType(String bankType)
    {
        this.bankType = bankType;
    }

    public String getAppid()
    {
        return appid;
    }

    public void setAppid(String appid)
    {
        this.appid = appid;
    }

    public String getSubAppid()
    {
        return subAppid;
    }

    public void setSubAppid(String subAppid)
    {
        this.subAppid = subAppid;
    }

    public String getOpenid()
    {
        return openid;
    }

    public void setOpenid(String openid)
    {
        this.openid = openid;
    }

    public String getSubOpenid()
    {
        return subOpenid;
    }

    public void setSubOpenid(String subOpenid)
    {
        this.subOpenid = subOpenid;
    }

    public String getBuyerLogonId()
    {
        return buyerLogonId;
    }

    public void setBuyerLogonId(String buyerLogonId)
    {
        this.buyerLogonId = buyerLogonId;
    }

    public String getBuyerUserId()
    {
        return buyerUserId;
    }

    public void setBuyerUserId(String buyerUserId)
    {
        this.buyerUserId = buyerUserId;
    }

    public String getExtend()
    {
        return extend;
    }

    public void setExtend(String extend)
    {
        this.extend = extend;
    }

    public PayInfo getPayInfo()
    {
        return payInfo;
    }

    public void setPayInfo(PayInfo payInfo)
    {
        this.payInfo = payInfo;
    }
}
