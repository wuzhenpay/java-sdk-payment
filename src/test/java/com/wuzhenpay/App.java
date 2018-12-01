package com.wuzhenpay;

import com.alibaba.fastjson.JSON;
import com.wuzhenpay.model.HttpResult;
import com.wuzhenpay.model.request.CloseReverseRequest;
import com.wuzhenpay.model.request.PayRequest;
import com.wuzhenpay.model.request.QueryRequest;
import com.wuzhenpay.model.request.RefundQueryRequest;
import com.wuzhenpay.model.request.RefundRequest;
import com.wuzhenpay.model.response.CloseReverseResp;
import com.wuzhenpay.model.response.PayResp;
import com.wuzhenpay.model.response.QueryResp;
import com.wuzhenpay.model.response.RefundResp;

/**
 * Hello world!
 */
public class App
{
    public static void main(String[] args)
    {


        WuzhenpayClient.init("1000000001", "51def6637bb3fcc11ca20cceb21c26f5");

//        pay();
//         query();
//         refund();
//         refundQuery();

        //close();

        //reverse();

    }

    public static void pay()
    {
        System.out.println("pay------------------");
        PayRequest payRequest = new PayRequest()
                                                .setOutTradeNo(System.currentTimeMillis() + "")
                                                .setTitle("test")
                                                .setPayMoney(1)
                                                .setOpenid("o2ry2jh6syo31iTMYVkA8jU_b1Fc")
                                                .setSubAppid("wx206cdad0c66cb7ca")
                                                .setBuyerId("2088402339754365")
                                                .setAuthCode("134672511156542924");
        HttpResult<PayResp> pay = WuzhenpayClient.pay(payRequest);
        System.out.println(JSON.toJSONString(pay));


    }

    public static void query()
    {
        System.out.println("query------------------");
        QueryRequest queryRequest = new QueryRequest().setPayNo("").setOutTradeNo("1543629639934");
        HttpResult<QueryResp> query = WuzhenpayClient.query(queryRequest);
        System.out.println(JSON.toJSONString(query));
    }

    public static void refund()
    {
        System.out.println("refund------------------");
        RefundRequest refundRequest = new RefundRequest().setPayNo("")
                                                         .setOutTradeNo("1543631373520")
                                                         .setOutRefundNo(System.currentTimeMillis() + "")
                                                         .setRefundFee(1);
        HttpResult<RefundResp> refund = WuzhenpayClient.refund(refundRequest);
        System.out.println(JSON.toJSONString(refund));
    }

    public static void refundQuery()
    {
        System.out.println("refundQuery------------------");
        RefundQueryRequest refundQueryRequest = new RefundQueryRequest().setOutRefundNo("1543631399703");
        HttpResult<RefundResp> refundQuery = WuzhenpayClient.refundQuery(refundQueryRequest);
        System.out.println(JSON.toJSONString(refundQuery));
    }

    public static void close()
    {
        System.out.println("close------------------");
        CloseReverseRequest closeReverseRequest = new CloseReverseRequest().setOutTradeNo("1543629639934");
        HttpResult<CloseReverseResp> refundQuery = WuzhenpayClient.close(closeReverseRequest);
        System.out.println(JSON.toJSONString(refundQuery));
    }

    public static void reverse()
    {
        System.out.println("reverse------------------");
        CloseReverseRequest closeReverseRequest = new CloseReverseRequest().setOutTradeNo("1543629639934");
        HttpResult<CloseReverseResp> refundQuery = WuzhenpayClient.reverse(closeReverseRequest);
        System.out.println(JSON.toJSONString(refundQuery));
    }
}
