# Wuzhenpay Payment API SDK For Java
该SDK封装了Wuzhenpay Payment API，方便使用。对于灵活度需求较高的商户可以直接对接Wuzhenpay Payment API。通讯协议及约定,加密方式，数据返回签名验证规则，支付类型介绍等可以查阅支付接口文档 
#### 接口文档地址
[Wuzhenpay Payment API](http://example.net/).


## 下载
> 暂时未上传

## 使用方法
``` 
WuzhenpayClient.init("1000000001", "51def6637bb3fcc11ca20cceb21c26f5");
```

### 交易支付（WuzhenpayClient::pay）
> 请求所需参数都在PayRequest内，参数意义参考支付接口文档

#### 1. 用户被扫 pay.xxx.code
> 用户被扫需要设置AuthCode，会自动判断是什么支付方式。
``` 
  PayRequest payRequest = new PayRequest().setAuthCode("1346725671562342924")
                                                .setOutTradeNo(System.currentTimeMillis() + "")
                                                .setTitle("test")
                                                .setPayMoney(1);
  HttpResult<PayResp> pay = WuzhenpayClient.pay(payRequest);
  System.out.println(JSON.toJSONString(pay));
``` 

#### 2. 用户主扫 pay.xxx.qrcode
> 用户主扫需要设置支付方式为wechatQrcode或者alipayQrcode
``` 
  PayRequest payRequest = new PayRequest().alipayQrcode()
                                                .setOutTradeNo(System.currentTimeMillis() + "")
                                                .setTitle("test")
                                                .setPayMoney(1);
  HttpResult<PayResp> pay = WuzhenpayClient.pay(payRequest);
  System.out.println(JSON.toJSONString(pay));
 ``` 

#### 2. js支付 pay.xxx.js
> js支付需要设置支付方式为wechatJs或者alipayJs, wechatJs需要设置openid,alipayJs需要设置buyerId
``` 
 PayRequest payRequest = new PayRequest().alipayJs()
                                                .setOutTradeNo(System.currentTimeMillis() + "")
                                                .setTitle("test")
                                                .setPayMoney(1)
                                                .setBuyerId("2182302339586365");
 HttpResult<PayResp> pay = WuzhenpayClient.pay(payRequest);
 System.out.println(JSON.toJSONString(pay));
 ``` 
 
 ### 交易查询 (WuzhenpayClient::query)
> 该接口提供所有支付订单的查询，商户可以通过该接口主动查询订单状态，完成下一步的业务逻辑。 需要调用查询接口的情况： 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知； 调用支付接口后，返回系统错误或未知交易状态情况；
``` 
   QueryRequest queryRequest = new QueryRequest().setPayNo("").setOutTradeNo("1543629639934");
   HttpResult<QueryResp> query = WuzhenpayClient.query(queryRequest);
   System.out.println(JSON.toJSONString(query));
``` 
 ### 交易退款 (WuzhenpayClient::refund)
 > 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，平台将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。 退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。总退款金额不能超过用户实际支付金额
 ``` 
   RefundRequest refundRequest = new RefundRequest().setPayNo("")
                                                         .setOutTradeNo("1543631373520")
                                                         .setOutRefundNo(System.currentTimeMillis() + "")
                                                         .setRefundFee(1);
   HttpResult<RefundResp> refund = WuzhenpayClient.refund(refundRequest);
   System.out.println(JSON.toJSONString(refund));
 ``` 

 ### 交易退款查询 (WuzhenpayClient::refundQuery)
 > 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
 ``` 
   RefundQueryRequest refundQueryRequest = new RefundQueryRequest().setOutRefundNo("1543631399703");
   HttpResult<RefundResp> refundQuery = WuzhenpayClient.refundQuery(refundQueryRequest);
   System.out.println(JSON.toJSONString(refundQuery));
 ``` 

 ### 撤销订单 (WuzhenpayClient::reverse)
 > 该接口主要用于**用户被扫**收款不明确的情况或者需要取消交易的情况，可以调用该接口。调用支付接口后请勿立即调用撤销订单接口，建议至少15s后再调用撤销订单接口。
 ``` 
  CloseReverseRequest closeReverseRequest = new CloseReverseRequest().setOutTradeNo("1543629639934");
  HttpResult<CloseReverseResp> reverse = WuzhenpayClient.reverse(closeReverseRequest);
  System.out.println(JSON.toJSONString(reverse));
 ``` 
 ### 关闭订单 (WuzhenpayClient::close)
 > 该接口主要用于**用户主扫** **js支付**收款不明确的情况或者需要取消交易的情况，商户订单支付失败需要生成新单号重新发起支付，要对原订单号调用关单，避免重复支付；系统下单后，用户支付超时，系统退出不再受理，避免用户继续，请调用关单接口。
 ``` 
   CloseReverseRequest closeReverseRequest = new CloseReverseRequest().setOutTradeNo("1543629639934");
   HttpResult<CloseReverseResp> close = WuzhenpayClient.close(closeReverseRequest);
   System.out.println(JSON.toJSONString(close));
 ``` 
 
 
### 异步通知
> 请求接口中提交的参数 notifyUrl，支付完成后，平台会把相关支付和用户信息发送到该 URL，商户需要接收处理信息。  

> 对后台通知交互时，如果平台收到商户的应答不是纯字符串success或超过5秒后返回时，平台认为通知失败，平台会通过一定的策略（通知频率为
> 0/15/30/180/1800/1800/1800/1800/3600，单位：秒）间接性重新发起通知，尽可能提高通知的成功率，但不保证通知最终能成功。  

> 注意：同样的通知可能会多次发送给商户系统。商户系统必须能够正确处理重复的通知。
  推荐的做法是，当收到通知进行处理时，首先检查对应业务数据的状态，判断该通知是否已经处理过，如果没有处理过再进行处理，如果处理过直接返回结果成功。在对   业务数据进行状态检查和处理之前，要采用数据锁进行并发控制，以避免函数重入造成的数据混乱。  

> 特别提醒：商户系统对于支付结果通知的内容一定要做签名验证,并校验返回的订单金额是否与商户侧的订单金额一致，防止数据泄漏导致出现“假通知”，造成资金损失。  

> 用户被扫（pay.xxx.code）不通知  

* 验证签名方式
``` 
{
    "code": "200",
    "data": {
        "charset": "utf-8",
        "payTime": "20181123154212",
        "payChannelTradeNo": "4200000190201811233096673115",
        "sign": "53aca0bb986966b81e9864bcc254bf0a",
        "isBankerAlgorithm": "N",
        "payNo": "100300000112018112315413110561",
        "thirdTradeNo": "4200000190201811233096673115",
        "payMoney": "1",
        "payType": "pay.wechat.qrcode",
        "merchantId": "1003000001",
        "outTradeNo": "2018112300000014",
        "signType": "md5",
        "timestamp": "20181123154216",
        "openid": "o2ry2jh6syo31iTMYVkA8jU_b1Fc",
        "format": "json",
        "feeType": "CNY",
        "appid": "wx206cdad0c66cb7ca",
        "ratio": "3.00",
        "status": "SUCCESS"
    },
    "message": "SUCCESS"
}
//对应data内容进行验签
WuzhenpayClient.checkSign(data);
``` 
