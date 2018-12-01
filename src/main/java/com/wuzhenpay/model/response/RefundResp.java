package com.wuzhenpay.model.response;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午4:17
 * Contact  519199662@qq.com
 */

public class RefundResp extends BaseResponse
{
    private String status;
    private String statusMsg;
    private String payType;
    private String payNo;
    private String outTradeNo;
    private String refundNo;
    private String outRefundNo;
    private String refundTime;
    private Long payMoney;
    private Long refundMoney;
    private Long refundTotal;
    private String ratio;
    private Long ratioMoney;
    private Long giveBackRatioMoney;
    private String refundFull;

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

    public String getPayType()
    {
        return payType;
    }

    public void setPayType(String payType)
    {
        this.payType = payType;
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

    public String getRefundNo()
    {
        return refundNo;
    }

    public void setRefundNo(String refundNo)
    {
        this.refundNo = refundNo;
    }

    public String getOutRefundNo()
    {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo)
    {
        this.outRefundNo = outRefundNo;
    }

    public String getRefundTime()
    {
        return refundTime;
    }

    public void setRefundTime(String refundTime)
    {
        this.refundTime = refundTime;
    }

    public Long getPayMoney()
    {
        return payMoney;
    }

    public void setPayMoney(Long payMoney)
    {
        this.payMoney = payMoney;
    }

    public Long getRefundMoney()
    {
        return refundMoney;
    }

    public void setRefundMoney(Long refundMoney)
    {
        this.refundMoney = refundMoney;
    }

    public Long getRefundTotal()
    {
        return refundTotal;
    }

    public void setRefundTotal(Long refundTotal)
    {
        this.refundTotal = refundTotal;
    }

    public String getRatio()
    {
        return ratio;
    }

    public void setRatio(String ratio)
    {
        this.ratio = ratio;
    }

    public Long getRatioMoney()
    {
        return ratioMoney;
    }

    public void setRatioMoney(Long ratioMoney)
    {
        this.ratioMoney = ratioMoney;
    }

    public Long getGiveBackRatioMoney()
    {
        return giveBackRatioMoney;
    }

    public void setGiveBackRatioMoney(Long giveBackRatioMoney)
    {
        this.giveBackRatioMoney = giveBackRatioMoney;
    }

    public String getRefundFull()
    {
        return refundFull;
    }

    public void setRefundFull(String refundFull)
    {
        this.refundFull = refundFull;
    }
}
