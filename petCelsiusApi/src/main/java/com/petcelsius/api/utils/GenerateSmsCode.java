package com.petcelsius.api.utils;

public class GenerateSmsCode {

    public static String generateSmsCode(){

        Integer smsCodeNumber = (int)((Math.random()*9+1)*1000);

        String smsCode = String.valueOf(smsCodeNumber);
        return smsCode;

    }

    public static void main(String[] args) {
        String s = GenerateSmsCode.generateSmsCode();
        System.out.println(s);
    }





}
