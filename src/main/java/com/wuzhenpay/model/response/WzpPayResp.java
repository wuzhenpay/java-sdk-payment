package com.wuzhenpay.model.response;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午3:22
 * Contact  519199662@qq.com
 */

public class WzpPayResp extends WzpResp
{

	private static final long serialVersionUID = 6382045685793901411L;

	private String thirdTradeNo; // 交易流水号

    private String payType;   //支付方式

    private long payMoney;  //支付金额		

    private String payTime; //支付时间

    private double rate; //费率

    private long rateMoney; //费率金额

    private String isBankerAlgorithm;//

    private String sourceData;

    private String extend;

    private String payInfo;

    public String getThirdTradeNo()
    {
        return thirdTradeNo;
    }

    public void setThirdTradeNo(String thirdTradeNo)
    {
        this.thirdTradeNo = thirdTradeNo;
    }

    public String getPayType()
    {
        return payType;
    }

    public void setPayType(String payType)
    {
        this.payType = payType;
    }

    public long getPayMoney()
    {
        return payMoney;
    }

    public void setPayMoney(long payMoney)
    {
        this.payMoney = payMoney;
    }

    public String getPayTime()
    {
        return payTime;
    }

    public void setPayTime(String payTime)
    {
        this.payTime = payTime;
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

    public String getIsBankerAlgorithm()
    {
        return isBankerAlgorithm;
    }

    public void setIsBankerAlgorithm(String isBankerAlgorithm)
    {
        this.isBankerAlgorithm = isBankerAlgorithm;
    }

    public String getSourceData()
    {
        return sourceData;
    }

    public void setSourceData(String sourceData)
    {
        this.sourceData = sourceData;
    }

    public String getExtend()
    {
        return extend;
    }

    public void setExtend(String extend)
    {
        this.extend = extend;
    }

    public String getPayInfo()
    {
        return payInfo;
    }

    public void setPayInfo(String payInfo)
    {
        this.payInfo = payInfo;
    }
}
