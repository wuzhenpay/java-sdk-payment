package com.wuzhenpay.model.response;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午4:17
 * Contact  519199662@qq.com
 */

public class WzpRefundResp extends WzpResp
{
	private static final long serialVersionUID = 4359319113813199474L;

	private String refundNo;

    private String outRefundNo;

    private long refundMoney;

    private double rate;

    private long rateMoney;

    private String refundTime;


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

    public long getRefundMoney()
    {
        return refundMoney;
    }

    public void setRefundMoney(long refundMoney)
    {
        this.refundMoney = refundMoney;
    }

    public double getRate()
    {
        return rate;
    }

    public void setRate(double rate)
    {
        this.rate = rate;
    }

    public long getRateMoney()
    {
        return rateMoney;
    }

    public void setRateMoney(long rateMoney)
    {
        this.rateMoney = rateMoney;
    }

    public String getRefundTime()
    {
        return refundTime;
    }

    public void setRefundTime(String refundTime)
    {
        this.refundTime = refundTime;
    }
}
