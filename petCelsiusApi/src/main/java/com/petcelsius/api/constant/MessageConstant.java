package com.petcelsius.api.constant;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 相应对象的消息常量类
 */
public class MessageConstant {
    // 短信常量
    public static final String SEND_VALIDATECODE_SUCCESS = "发送验证码成功";
    public static final String SEND_VALIDATECODE_FAIL = "发送验证码失败";
    public static final String MOBILE_CODE_FAIL = "手机号格式错误";

    // 邮件常量
    public static final String SEND_EMAILCODE_SUCCESS = "发送邮箱验证码成功";
    public static final String SEND_EMAILCODE_FAIL = "发送邮箱验证码失败";
    public static final String EMAIL_CODE_FAIL = "手机号格式错误";


    // redis常量
    public static final String REDIS_CONNECTION_FAIL = "redis链接失败";

}