package com.petcelsius.api.utils;

import java.util.Random;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 生成短信验证码工具类
 */

public class GenerateSmsCode {

    public static String generateSmsCode(){

        int smsCodeNumber = new Random().nextInt(9999) + 1000;

        String smsCode = String.valueOf(smsCodeNumber);
        return smsCode;

    }

    public static void main(String[] args) {
        String s = GenerateSmsCode.generateSmsCode();
        System.out.println(s);
    }





}
