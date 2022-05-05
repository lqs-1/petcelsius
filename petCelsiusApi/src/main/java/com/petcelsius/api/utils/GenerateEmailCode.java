package com.petcelsius.api.utils;

import java.util.Random;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 生成邮件验证码工具类
 */

public class GenerateEmailCode {

    public static String generateEmailCode(){
        /**
         * 生成随机数：
         *  radmon.nextInt(可以产生多少个随机数) + 从哪里开始
         *  通过这个公式就会在这个范围随机产生一个符合要求的随机数
         */
        int emailCodeNumber = new Random().nextInt(9999) + 1000;

        String emailCode = String.valueOf(emailCodeNumber);
        return emailCode;

    }

    public static void main(String[] args) {
        String s = GenerateEmailCode.generateEmailCode();
        System.out.println(s);
    }


}
