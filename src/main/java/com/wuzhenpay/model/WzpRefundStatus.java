package com.wuzhenpay.model;

public enum WzpRefundStatus
{
    FAIL(-1, "退款失败"), REFUND_CONDUCT(0, "退款中"), SUCCESS(1, "退款成功");

    private int code;
    private String desc;

    WzpRefundStatus(int code, String desc)
    {

        this.code = code;
        this.desc = desc;
    }

    public int getCode()
    {
        return code;
    }


    public String getDesc()
    {
        return desc;
    }

    /**
     * 根据值获取枚举对象
     *
     * @param code
     * @return
     */
    public static String getDesc(int code)
    {
        for (WzpRefundStatus item : WzpRefundStatus.values())
        {
            if (item.getCode() == code)
            {
                return item.getDesc();
            }
        }
        return null;
    }

    public static WzpRefundStatus getObject(int code)
    {
        for (WzpRefundStatus item : WzpRefundStatus.values())
        {
            if (item.getCode() == code)
            {
                return item;
            }
        }
        return null;
    }


    public static String getRefundStatus(String status)
    {
        switch (status)
        {
            case "SUCCESS":
                return "S";
            case "FAIL":
                return "F";
            default:
                return "U";
        }
    }
}
