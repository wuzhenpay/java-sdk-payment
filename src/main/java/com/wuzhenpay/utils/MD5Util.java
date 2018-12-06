package com.wuzhenpay.utils;


import com.wuzhenpay.WuzhenpayClient;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by aspros on 16/4/8.
 */
public class MD5Util
{

    public static String md5Hex(String string)
    {
        return DigestUtils.md5Hex(string).toLowerCase();
    }

    public static String getHSign(Map<String, String> map, boolean print)
    {
        if (map == null || map.size() == 0)
        {
            return "";
        }
        List<String> list = new ArrayList<>();

        for (String key : map.keySet())
        {
            if (map.get(key) == null || map.get(key).length() == 0)
            {
                list.add(key);
            }
        }
        for (String key : list)
        {
            map.remove(key);
        }
        list.clear();
        for (String key : map.keySet())
        {
            if (key.equals("sign"))
            {
                continue;
            }
            list.add(key + "=" + map.get(key));
        }
        if (list.size() == 0)
        {
            return "";
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder(list.get(0));
        for (int i = 1; i < list.size(); i++)
        {
            sb.append("&" + list.get(i));
        }
        sb.append("&secret=" + WuzhenpayClient.secret);


        String data = sb.toString();
        if (print)
        {
            System.out.println("[ 拼接后数据 ]");
            System.out.println(data);
        }
        return md5Hex(data);

    }
}
