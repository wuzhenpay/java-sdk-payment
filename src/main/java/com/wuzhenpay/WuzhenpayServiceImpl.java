package com.wuzhenpay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.wuzhenpay.model.request.WzpAuthinfoRequest;
import com.wuzhenpay.model.request.WzpCloseReverseRequest;
import com.wuzhenpay.model.request.WzpPayRequest;
import com.wuzhenpay.model.request.WzpQueryRequest;
import com.wuzhenpay.model.request.WzpRefundQueryRequest;
import com.wuzhenpay.model.request.WzpRefundRequest;
import com.wuzhenpay.model.response.HttpResult;
import com.wuzhenpay.model.response.WzpAuthInfoResp;
import com.wuzhenpay.model.response.WzpPayResp;
import com.wuzhenpay.model.response.WzpRefundResp;
import com.wuzhenpay.model.response.WzpResp;
import com.wuzhenpay.utils.HttpsUtil;
import com.wuzhenpay.utils.MD5Util;


import java.util.Map;
import java.util.TreeMap;

/**
 * Author:  aspros
 * Date:  2019/5/15 下午2:38
 * Contact  519199662@qq.com
 */
public class WuzhenpayServiceImpl implements WuzhenpayService
{
    private String baseUrl = "https://api.wuzhenpay.com";

    private final String payPath = "/trade/pay";

    private final String queryPath = "/trade/query";

    private final String refundPath = "/trade/refund";

    private final String refundQueryPath = "/trade/refund/query";

    private final String closePath = "/trade/close";

    private final String reversePath = "/trade/reverse";

    private final String authinfo = "/trade/getWXFacepayAuthinfo";


    @Override
    public boolean checkSign(String data, String secret)
    {

        TreeMap<?, ?> treeMap = JSONObject.parseObject(data, TreeMap.class);

        String sign = MD5Util.sign(treeMap, secret);

        return sign.equals(treeMap.get("sign"));
    }

    private <T extends WzpResp> HttpResult<T> parseResult(String s, Class<T> t, String secret)
    {
        HttpResult<String> result = JSON.parseObject(s, new TypeReference<HttpResult<String>>()
        {
        });

        HttpResult<T> httpResult = new HttpResult<>();
        httpResult.code = result.code;
        httpResult.message = result.message;

        if (result.code == 200)
        {
            if (!checkSign(result.data, secret))
            {

                System.out.println("返回数据 签名异常 " + result.data);
            }

            httpResult.data = JSONObject.parseObject(result.data, t);
        }
        else
        {
            return httpResult;
        }


        return httpResult;
    }

    private <T extends WzpResp> HttpResult<T> excute(String path, Map<String, String> param, String secret, Class<T> t)
    {
        try
        {
            String s = HttpsUtil.httpPostRequest(baseUrl + path, param);
            return parseResult(s, t, secret);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        HttpResult<T> httpResult = new HttpResult<>();
        httpResult.setCode(523);
        httpResult.setMessage("网络开小差,请重试");
        return httpResult;

    }

    @Override
    public HttpResult<WzpPayResp> pay(WzpPayRequest request, String merchantId, String secret)
    {
        Map<String, String> param = request.createParam(merchantId, secret);
        if (param.get("auth_code") != null && param.get("pay_type") == null)
        {
            HttpResult<WzpPayResp> httpResult = new HttpResult<>();
            httpResult.setCode(400);
            httpResult.setMessage("付款码错误,请重试");
            return httpResult;

        }

        return excute(payPath, param, secret, WzpPayResp.class);

    }

    @Override
    public HttpResult<WzpPayResp> query(WzpQueryRequest request, String merchantId, String secret)
    {
        return excute(queryPath, request.createParam(merchantId, secret), secret, WzpPayResp.class);
    }

    @Override
    public HttpResult<WzpRefundResp> refund(WzpRefundRequest request, String merchantId, String secret)
    {
        return excute(refundPath, request.createParam(merchantId, secret), secret, WzpRefundResp.class);

    }

    @Override
    public HttpResult<WzpRefundResp> refundQuery(WzpRefundQueryRequest request, String merchantId, String secret)
    {
        return excute(refundQueryPath, request.createParam(merchantId, secret), secret, WzpRefundResp.class);

    }

    @Override
    public HttpResult<WzpResp> close(WzpCloseReverseRequest request, String merchantId, String secret)
    {
        return excute(closePath, request.createParam(merchantId, secret), secret, WzpResp.class);

    }

    @Override
    public HttpResult<WzpResp> reverse(WzpCloseReverseRequest request, String merchantId, String secret)
    {
        return excute(reversePath, request.createParam(merchantId, secret), secret, WzpResp.class);
    }

    @Override
    public HttpResult<WzpAuthInfoResp> getAuthinfo(WzpAuthinfoRequest request, String merchantId, String secret)
    {
        return excute(authinfo, request.createParam(merchantId, secret), secret, WzpAuthInfoResp.class);
    }
}