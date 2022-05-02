package com.petcelsius.api.utils;

import com.petcelsius.api.constant.Constant;

import java.util.regex.Pattern;


/**
 * 正则工具类
 */

public class Re {

    public static Boolean mobileNumberValidate(String mobile){
        boolean isFag = Pattern.matches(Constant.MOBILE_REGEX, mobile);
        return isFag;
    }

    public static Boolean emailValidate(String email){
        boolean isFag = Pattern.matches(Constant.EMAIL_REGEX, email);
        return isFag;
    }

    public static void main(String[] args) {
        Boolean isMobile = Re.mobileNumberValidate("17398827615");
        System.out.println(isMobile);

        Boolean isEmail = Re.emailValidate("749062870@qq.com");
        System.out.println(isEmail);
    }

}
