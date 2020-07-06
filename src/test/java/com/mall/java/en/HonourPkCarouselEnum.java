package com.mall.java.en;

import lombok.Getter;

@Getter
public enum HonourPkCarouselEnum {
    /**
     * 1是参与PK
     */
    HONOUR_CAROUSEL_PK("参与PK",1),
    /**
     * 2是PK奖励
     */
    HONOUR_CAROUSEL_PK_REWARD("PK奖励",2),
    /**
     * 3是进入榜单
     */
    HONOUR_CAROUSEL_TOP("进入榜单",3),
    /**
     * 4是夺得月榜单
     */
    HONOUR_CAROUSEL_MONTH_TOP("夺得月榜单",4),
    /**
     * 5是夺得周榜单
     */
    HONOUR_CAROUSEL_WEEK_TOP("夺得周榜单",5),
    /**
     * 6是夺得日榜单
     */
    HONOUR_CAROUSEL_DAY_TOP("夺得日榜单",6);


    private String desc;
    private Integer code;

    HonourPkCarouselEnum(String desc, Integer code) {
        this.desc = desc;
        this.code = code;
    }

    public static String valueOf(Integer status) {
        if (status == null) {
            return "";
        } else {
            HonourPkCarouselEnum[] val = values();
            int len = val.length;

            for (int i = 0; i < len; ++i) {
                HonourPkCarouselEnum s = val[i];
                if (s.getCode().equals(status)) {
                    return s.getDesc();
                }
            }
            return "";
        }
    }

}
