package com.wuzhenpay.utils;


import com.sun.tools.javac.util.StringUtils;
import com.wuzhenpay.WuzhenpayClient;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by aspros on 16/4/8.
 */
public class MD5Util
{
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    // 十六进制下数字到字符的映射数组

    /**
     * 把inputString加密
     */
    public static String createPassword(String inputString)
    {
        return encodeByMD5(inputString).toLowerCase();
    }

    /**
     * 验证输入的密码是否正确
     *
     * @param password    真正的密码（加密后的真密码）
     * @param inputString 输入的字符串
     * @return 验证结果，boolean类型
     */
    public static boolean authenticatePassword(String password, String inputString)
    {
        if (password.equals(encodeByMD5(inputString)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 对字符串进行MD5编码
     */
    private static String encodeByMD5(String originString)
    {
        if (originString != null)
        {
            try
            {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                // 将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 轮换字节数组为十六进制字符串
     *
     * @param b 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b)
    {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
        {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /**
     * 将一个字节转化成十六进制形式的字符串
     */
    private static String byteToHexString(byte b)
    {
        int n = b;
        if (n < 0)
        {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


    public static int length(String value)
    {
        int valueLength = 0;
        String chinese = "[\u0391-\uFFE5]";
        for (int i = 0; i < value.length(); i++)
        {
            String temp = value.substring(i, i + 1);
            if (temp.matches(chinese))
            {
                valueLength += 2;
            }
            else
            {
                valueLength += 1;
            }
        }
        return valueLength;
    }

    public static String getHSign(Map<String, String> map)
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

        return createPassword(sb.toString());

    }
}
