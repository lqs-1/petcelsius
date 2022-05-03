package com.petcelsius.api.constant;

public class Constant {
    // 分页参数常量
    public static final String PAGE = "page";
    public static final String LIMIT = "limit";
    public static final String ORDERFILED = "orderFiled";
    public static final String ORDERTYPE = "orderType";

    // 消息队列常量
    public static final String SENDSMSCODEEXCHANGE = "sms_exchange";
    public static final String SENDSMSCODEQUEUE = "sms_queue";
    public static final String SENDSMSCODEROUTERKEY = "sms.#";


    // 正则常量
    public static final String MOBILE_REGEX = "^1[356789]{1}[0-9]{9}$";
    public static final String EMAIL_REGEX = "^\\w+@\\w+\\.\\w+$";


    // redis里面卖的验证码过期时间（短信和邮箱通用）
    public static final Integer VALIDATE_TIMEOUT = 60*5;
    // 存在redis中的验证码的key前缀
    public static final String EMAIL_PREFIX = "email";
    public static final String SMSCODE_PREFIX = "sms";


    // 邮件发件人昵称
    public static final String NICK_NAME = "宠物℃";
}
