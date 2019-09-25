package com.wuzhenpay.model;

/**
 * 支付状态/交易状态
 * 充值信息表,交易状态status字段
 * <p>
 * -1	已取消/已关闭/已撤销
 * 0	未支付
 * 1	支付成功
 * 2	支付中
 * 3	已结单
 * 4	转入退款
 * 5	支付异常
 * 6	失败
 */
public enum WzpOrderStatus
{
    CLOSED(-1), NOTPAY(0), SUCCESS(1), PAYING(2), FINISH(3), REFUND(4), UNUSUAL(5), FAIL(6);

    private Integer code;

    WzpOrderStatus(Integer code)
    {
        this.code = code;
    }

    public Integer getCode()
    {
        return code;
    }

    /**
     * 根据值获取枚举对象
     *
     * @param value
     * @return
     */
    public static WzpOrderStatus getObject(Integer value)
    {
        for (WzpOrderStatus item : WzpOrderStatus.values())
        {
            if (item.getCode().equals(value))
            {
                return item;
            }
        }
        return null;
    }

    /**
     * 根据名称获取枚举对象
     *
     * @param key
     * @return
     */
    public static WzpOrderStatus getObject(String key)
    {
        for (WzpOrderStatus item : WzpOrderStatus.values())
        {
            if (item.name().equals(key))
            {
                return item;
            }
        }
        return null;
    }

}
