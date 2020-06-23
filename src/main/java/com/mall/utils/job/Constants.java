package com.mall.utils.job;

public class Constants {
    public final static String DEFAULT_ENCODING="UTF-8";

    public static class EncryptType{
        public final static String MD5="md5";
        public final static String SHA="sha";
    }

    public static class MAIL{
        public final static String SERVERIP = "mail.serverIp";
        public final static String PORT = "mail.port";
        public final static String SSL = "mail.ssl";
        public final static String USERNAME = "mail.username";
        public final static String PASSWORD = "mail.password";
        public final static String FROM = "mail.from";
        public final static String FROM_NAME = "mail.fromName";
        public final static String IS_DEBUG = "mail.isDebug";
    }

    /**
     * 定时任务状态
     */
    public enum ScheduleStatus {
        /**
         * 正常
         */
        NORMAL(0),
        /**
         * 暂停
         */
        PAUSE(1);

        private int value;

        private ScheduleStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 超级管理员
     */
    public static class SuperAdmin{
        public final static long SUPER_ADMIN = 11L;//11439950771640L;


    }

    /**
     * 运营后台用户名称
     */
    public static final String CURRENT_SUPER_USER = "superadminLoginUser";
    /**
     * 供应商商户后台用户名称
     */
    public static final String CURRENT_SUPPLIER_USER = "supplierLoginUser";

    public static final String AJAX_ERROR_300="300";
    public static final String AJAX_ERROR_330="330";
}
