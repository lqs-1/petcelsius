package com.petcelsius.api.constant;

import java.nio.charset.StandardCharsets;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 内部使用常量类
 */
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
    // 短信名称
    public static final String SMS_SERVICE_NAME = "宠物℃";
    public static final String SMS_TEMPLATE = "SMS_154950909";
    public static final String SMS_TEMPLATE_BY_RLY_ID = "1";


    // 信息摘要返回结果名
    public static final String DIGEST_RESULT_NAME = "digest_code";

    // 加密信息返回结果名，加密解密用同一个，也就是明文密文用同一个
    public static final String CIPHER_RESULT_NAME = "cipher_code";

}
