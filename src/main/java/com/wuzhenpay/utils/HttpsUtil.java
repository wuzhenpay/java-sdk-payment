package com.wuzhenpay.utils;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author:  aspros
 * Date:  2018/9/5 下午1:19
 * Contact  519199662@qq.com
 */

public class HttpsUtil
{
    public static final int SIGN_ERROR_CODE = 23333;
    public static final int ERROR_CODE = 23334;

    public static OkHttpClient client;

    static
    {
        try
        {
            client = setSSL(true);
        }
        catch (Exception e)
        {
        }
    }

    public static void init(boolean debug)
    {
        try
        {
            client = setSSL(debug);
        }
        catch (Exception e)
        {
        }
    }


    private static OkHttpClient setSSL(boolean debug) throws Exception
    {
        final X509TrustManager trustManager = new X509TrustManager()
        {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException
            {

            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException
            {

            }

            @Override
            public X509Certificate[] getAcceptedIssuers()
            {
                return new X509Certificate[0];
            }
        };

        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[]{trustManager}, new SecureRandom());
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();


        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        //设置超时时间
        httpClientBuilder.connectTimeout(10, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(10, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(10, TimeUnit.SECONDS);


        if (debug)
        {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        }

        return httpClientBuilder.sslSocketFactory(sslSocketFactory, trustManager)
                                .hostnameVerifier(new HostnameVerifier()
                                {
                                    @Override
                                    public boolean verify(String hostname, SSLSession session)
                                    {
                                        return true;
                                    }
                                })
                                .build();

    }

    public static String httpXMLRequest(String url, String param)
    {
        try
        {

            RequestBody body = RequestBody.create(MediaType.parse("text/xml; charset=utf-8"), param);
            Request request = new Request.Builder().url(url).post(body).build();
            Response response = client.newCall(request).execute();
            if (response.body() == null || response.code() != 200)
            {
                return null;
            }
            return response.body().string();
        }
        catch (IOException e)
        {
            return null;
        }
    }

    public static String httpJSONRequest(String url, String param)
    {
        try
        {

            RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), param);
            Request request = new Request.Builder().url(url).post(body).build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200 && response.body() != null)
            {
                return response.body().string();
            }
            else
            {
                return getErrorResult(response.code(), response.message());
            }
        }
        catch (IOException e)
        {
            return getErrorResult(ERROR_CODE, e.getMessage());
        }
    }

    public static String httpPostRequest(String url, Map<String, String> param)
    {
        try
        {
            RequestBody body = setRequestBody(param);
            Request.Builder requestBuilder = new Request.Builder();
            Request request = requestBuilder.post(body).url(url).build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200 && response.body() != null)
            {
                return response.body().string();
            }
            else
            {
                return getErrorResult(response.code(), response.message());
            }

        }
        catch (IOException e)
        {
            return getErrorResult(ERROR_CODE, e.getMessage());
        }
    }

    public static String httpGetRequest(String url, Map<String, String> param)
    {
        try
        {
            Request.Builder requestBuilder = new Request.Builder();
            Request request = requestBuilder.url(getUrl(url, param)).build();
            Response response = client.newCall(request).execute();
            if (response.code() == 200 && response.body() != null)
            {
                return response.body().string();
            }
            else
            {
                return getErrorResult(response.code(), response.message());
            }
        }
        catch (IOException e)
        {
            return getErrorResult(ERROR_CODE, e.getMessage());
        }
    }

    private static String getErrorResult(int code, String message)
    {

        return null;
    }

    private static String getUrl(String url, Map<String, String> params)
    {
        if (params != null)
        {
            Iterator<String> it = params.keySet().iterator();
            StringBuffer sb = null;
            while (it.hasNext())
            {
                String key = it.next();
                String value = params.get(key);
                if (sb == null)
                {
                    sb = new StringBuffer();
                    sb.append("?");
                }
                else
                {
                    sb.append("&");
                }
                sb.append(key);
                sb.append("=");
                sb.append(value);
            }
            url += sb.toString();
        }
        return url;
    }

    private static RequestBody setRequestBody(Map<String, String> BodyParams)
    {
        RequestBody body = null;
        okhttp3.FormBody.Builder formEncodingBuilder = new okhttp3.FormBody.Builder();
        if (BodyParams != null)
        {
            Iterator<String> iterator = BodyParams.keySet().iterator();
            String key = "";
            while (iterator.hasNext())
            {
                key = iterator.next();
                formEncodingBuilder.add(key, BodyParams.get(key));
            }
        }
        body = formEncodingBuilder.build();
        return body;

    }

}
