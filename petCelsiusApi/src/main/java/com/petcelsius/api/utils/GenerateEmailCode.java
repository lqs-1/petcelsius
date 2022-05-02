package com.petcelsius.api.utils;

import java.util.Random;

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
