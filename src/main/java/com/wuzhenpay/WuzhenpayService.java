package com.wuzhenpay;

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

/**
 * Author:  aspros
 * Date:  2019/5/15 下午2:36
 * Contact  519199662@qq.com
 */

public interface WuzhenpayService
{
    boolean checkSign(String data, String secret);

    HttpResult<WzpPayResp> pay(WzpPayRequest request, String merchantId, String secret);

    HttpResult<WzpPayResp> query(WzpQueryRequest request, String merchantId, String secret);

    HttpResult<WzpRefundResp> refund(WzpRefundRequest request, String merchantId, String secret);

    HttpResult<WzpRefundResp> refundQuery(WzpRefundQueryRequest request, String merchantId, String secret);

    HttpResult<WzpResp> close(WzpCloseReverseRequest request, String merchantId, String secret);

    HttpResult<WzpResp> reverse(WzpCloseReverseRequest request, String merchantId, String secret);

    HttpResult<WzpAuthInfoResp> getAuthinfo(WzpAuthinfoRequest request, String merchantId, String secret);
}
