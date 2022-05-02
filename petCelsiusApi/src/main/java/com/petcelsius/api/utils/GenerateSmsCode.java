package com.petcelsius.api.utils;

import java.util.Random;

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
