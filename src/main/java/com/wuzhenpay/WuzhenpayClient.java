package com.wuzhenpay;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.wuzhenpay.model.HttpResult;
import com.wuzhenpay.model.request.CloseReverseRequest;
import com.wuzhenpay.model.request.PayRequest;
import com.wuzhenpay.model.request.QueryRequest;
import com.wuzhenpay.model.request.RefundQueryRequest;
import com.wuzhenpay.model.request.RefundRequest;
import com.wuzhenpay.model.response.BaseResponse;
import com.wuzhenpay.model.response.CloseReverseResp;
import com.wuzhenpay.model.response.PayResp;
import com.wuzhenpay.model.response.QueryResp;
import com.wuzhenpay.model.response.RefundResp;
import com.wuzhenpay.utils.HttpsUtil;
import com.wuzhenpay.utils.MD5Util;

import java.util.Map;

/**
 * Author:  aspros
 * Date:  2018/11/30 下午12:53
 * Contact  519199662@qq.com
 */

public class WuzhenpayClient
{
    public static final String baseUrl = "https://payment.wuzhenpay.com";

    public static final String payPath = "/trade/pay";

    public static final String queryPath = "/trade/query";

    public static final String refundPath = "/trade/refund";

    public static final String refundQueryPath = "/trade/refund/query";

    public static final String closePath = "/trade/close";

    public static final String reversePath = "/trade/reverse";

    public static String merchantId;
    public static String secret;

    private static boolean debugMode;


    public static void init(String merchantId, String secret)
    {
        WuzhenpayClient.merchantId = merchantId;
        WuzhenpayClient.secret = secret;
    }

    public static void setDebugMode(boolean debug)
    {
        debugMode=debug;
        HttpsUtil.init(debug);
    }

    public static boolean checkSign(String data)
    {
        if(debugMode)
        {
            System.out.println("[ 待验签数据 ]");
            System.out.println(data);
        }
        Map<String, String> map = JSON.parseObject(data, new TypeReference<Map<String, String>>()
        {
        });
        String sign = MD5Util.getHSign(map);

        if(debugMode)
        {
            System.out.println("[ 签名信息 ]");
            System.out.println(sign);
        }
        return sign.equals(map.get("sign"));
    }

    public static <T extends BaseResponse> HttpResult<T> parseResult(String s, Class<T> t)
    {
        HttpResult<String> result = JSON.parseObject(s, new TypeReference<HttpResult<String>>()
        {
        });

        HttpResult<T> httpResult = new HttpResult<>();

        if (result.code == 200)
        {
            if (!checkSign(result.data))
            {
                httpResult.code = HttpsUtil.SIGN_ERROR_CODE;
                httpResult.errorMsg = "签名错误";
                return httpResult;
            }
        }

        httpResult.code = result.code;
        httpResult.message = result.message;
        httpResult.errorMsg = result.errorMsg;
        httpResult.data = JSON.parseObject(result.data, t);

        return httpResult;
    }

    public static HttpResult<PayResp> pay(PayRequest request)
    {
        Map<String, String> param = request.createParam();
        if (param.get("authCode") != null && param.get("payType") == null)
        {
            HttpResult<PayResp> httpResult = new HttpResult<>();
            httpResult.code = HttpsUtil.ERROR_CODE;
            httpResult.errorMsg = "非法支付条码";
            return httpResult;

        }

        String s = HttpsUtil.httpPostRequest(baseUrl + payPath, param);
        return parseResult(s, PayResp.class);
    }

    public static HttpResult<QueryResp> query(QueryRequest request)
    {
        String s = HttpsUtil.httpPostRequest(baseUrl + queryPath, request.createParam());
        return parseResult(s, QueryResp.class);
    }


    public static HttpResult<RefundResp> refund(RefundRequest request)
    {
        String s = HttpsUtil.httpPostRequest(baseUrl + refundPath, request.createParam());
        return parseResult(s, RefundResp.class);
    }

    public static HttpResult<RefundResp> refundQuery(RefundQueryRequest request)
    {
        String s = HttpsUtil.httpPostRequest(baseUrl + refundQueryPath, request.createParam());
        return parseResult(s, RefundResp.class);
    }

    public static HttpResult<CloseReverseResp> close(CloseReverseRequest request)
    {
        String s = HttpsUtil.httpPostRequest(baseUrl + closePath, request.createParam());
        return parseResult(s, CloseReverseResp.class);
    }

    public static HttpResult<CloseReverseResp> reverse(CloseReverseRequest request)
    {
        String s = HttpsUtil.httpPostRequest(baseUrl + reversePath, request.createParam());
        return parseResult(s, CloseReverseResp.class);
    }
}