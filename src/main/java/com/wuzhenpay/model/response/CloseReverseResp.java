package com.wuzhenpay.model.response;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午4:24
 * Contact  519199662@qq.com
 */

public class CloseReverseResp extends BaseResponse
{
    private String status;
    private String statusMsg;

    private String payNo;
    private String outTradeNo;
    private String payType;
    private String payMoney;

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

    public String getPayType()
    {
        return payType;
    }

    public void setPayType(String payType)
    {
        this.payType = payType;
    }

    public String getPayMoney()
    {
        return payMoney;
    }

    public void setPayMoney(String payMoney)
    {
        this.payMoney = payMoney;
    }
}
