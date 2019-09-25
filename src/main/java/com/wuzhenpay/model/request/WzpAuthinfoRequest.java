package com.wuzhenpay.model.request;

/**
 * Author:  aspros
 * Date:  2019/9/23 下午12:36
 * Contact  519199662@qq.com
 */

public class WzpAuthinfoRequest extends WzpBaseRequest
{
    public WzpAuthinfoRequest setRawdata(String rawdata)
    {
        param.put("rawdata", rawdata);
        return this;
    }

    public WzpAuthinfoRequest setSubAppid(String subAppid)
    {
        param.put("subAppid", subAppid);
        return this;
    }

    public WzpAuthinfoRequest setTerminalId(Integer terminalId)
    {
        param.put("terminalId", String.format("%08d",terminalId));
        return this;
    }
}
