package com.wuzhenpay;

import com.wuzhenpay.model.request.WzpCloseReverseRequest;
import com.wuzhenpay.model.request.WzpPayRequest;
import com.wuzhenpay.model.request.WzpQueryRequest;
import com.wuzhenpay.model.request.WzpRefundQueryRequest;
import com.wuzhenpay.model.request.WzpRefundRequest;

/**
 * Hello world!
 */
public class App
{

    private static String merchantId = "1000000318";
    private static String secreat = "e6418e9217acd70b0b831a5859c4e7f2";

    public static void main(String[] args)
    {
//        pay();
//        query();
        refund();
    }

    public static void pay()
    {
        System.out.println("pay------------------");
        WzpPayRequest payRequest = new WzpPayRequest().setAuthCode("135315598690265211")
                                                      .setOutTradeNo(System.currentTimeMillis() + "")
                                                      .setTitle("testsss")
                                                      .setPayMoney(1L);

        WuzhenpayServiceImpl wuzhenpayService = new WuzhenpayServiceImpl();
        wuzhenpayService.pay(payRequest, merchantId, secreat);

    }

    public static void query()
    {
        System.out.println("query------------------");
        WzpQueryRequest queryRequest = new WzpQueryRequest().setOutTradeNo("1569387444444");

        WuzhenpayServiceImpl wuzhenpayService = new WuzhenpayServiceImpl();
        wuzhenpayService.query(queryRequest, merchantId, secreat);
    }

    public static void refund()
    {
        System.out.println("refund------------------");
        WzpRefundRequest refundRequest = new WzpRefundRequest().setOutTradeNo("1569387444444")
                                                               .setOutRefundNo(System.currentTimeMillis() + "")
                                                               .setRefundFee(1L);
        WuzhenpayServiceImpl wuzhenpayService = new WuzhenpayServiceImpl();
        wuzhenpayService.refund(refundRequest, merchantId, secreat);
    }

    public static void refundQuery()
    {
        System.out.println("refundQuery------------------");
        WzpRefundQueryRequest refundQueryRequest = new WzpRefundQueryRequest().setOutRefundNo("201903201349049290000002291436");
        WuzhenpayServiceImpl wuzhenpayService = new WuzhenpayServiceImpl();
        wuzhenpayService.refundQuery(refundQueryRequest, merchantId, secreat);
    }

    public static void close()
    {
        System.out.println("close------------------");
        WzpCloseReverseRequest closeReverseRequest = new WzpCloseReverseRequest().setOutTradeNo("201903201423598360000002239131");
        WuzhenpayServiceImpl wuzhenpayService = new WuzhenpayServiceImpl();
        wuzhenpayService.close(closeReverseRequest, merchantId, secreat);
    }

    public static void reverse()
    {
        System.out.println("reverse------------------");
        WzpCloseReverseRequest closeReverseRequest = new WzpCloseReverseRequest().setOutTradeNo("1552025331198");
        WuzhenpayServiceImpl wuzhenpayService = new WuzhenpayServiceImpl();
        wuzhenpayService.reverse(closeReverseRequest, merchantId, secreat);
    }
}

