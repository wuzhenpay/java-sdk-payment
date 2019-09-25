package com.wuzhenpay.utils;

import com.alibaba.fastjson.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.TreeMap;

/**
 * MD5 散列算法返回的128bit的编码，HEX编码后的长度为32Byte
 * <p>
 * Created by aspros on 16/4/8.
 */
public class MD5Util
{
    // md5加密salt,硬编码
    private final static String SALT = "wuzhenpay@wuzhenpay";

    public static String sign(TreeMap<?, ?> map, String secret)
    {
        StringBuilder builder = new StringBuilder();
        for (Object key : map.keySet())
        {
            if (key.equals("sign"))
            {
                continue;
            }
            Object value = map.get(key);
            if (null != value && String.valueOf(value).length() != 0)
            {
                builder.append(key).append("=").append(value).append("&");
            }
        }
        String linkString = builder.toString().concat("secret=").concat(secret);
        return DigestUtils.md5Hex(linkString);
    }


    public static boolean checkSign(String data, String secret)
    {

        TreeMap<?, ?> treeMap = JSONObject.parseObject(data, TreeMap.class);

        String sign = MD5Util.sign(treeMap, secret);

        return sign.equals(treeMap.get("sign"));
    }
}
