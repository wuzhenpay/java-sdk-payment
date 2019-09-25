package com.wuzhenpay.model.response;

/**
 * Author:  aspros
 * Date:  2019/9/23 下午12:39
 * Contact  519199662@qq.com
 */

public class WzpAuthInfoResp extends WzpResp
{
    private String mchId;

    private String subMchId;

    private String appid;

    private String subAppid;

    private String authinfo;

    private String returnCode;

    private String returnMsg;

    public String getMchId()
    {
        return mchId;
    }

    public void setMchId(String mchId)
    {
        this.mchId = mchId;
    }

    public String getSubMchId()
    {
        return subMchId;
    }

    public void setSubMchId(String subMchId)
    {
        this.subMchId = subMchId;
    }

    public String getAppid()
    {
        return appid;
    }

    public void setAppid(String appid)
    {
        this.appid = appid;
    }

    public String getSubAppid()
    {
        return subAppid;
    }

    public void setSubAppid(String subAppid)
    {
        this.subAppid = subAppid;
    }

    public String getAuthinfo()
    {
        return authinfo;
    }

    public void setAuthinfo(String authinfo)
    {
        this.authinfo = authinfo;
    }

    public String getReturnCode()
    {
        return returnCode;
    }

    public void setReturnCode(String returnCode)
    {
        this.returnCode = returnCode;
    }

    public String getReturnMsg()
    {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg)
    {
        this.returnMsg = returnMsg;
    }
}
