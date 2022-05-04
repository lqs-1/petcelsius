package com.petcelsius.api.utils;

import com.petcelsius.api.constant.Constant;
import org.apache.tomcat.util.bcel.Const;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/**
 * md5的工具类
 */
public class Md5Utils {


    // 普通方式
    public static R hexMD5(String originString, boolean isHug){
        if (isHug){
            return hugHexMD5(originString);
        }
        return simpleHexMD5(originString);
    }


    // 加盐方式
    public static R plusHexMD5(String originString, String plusString, boolean isHug){
        if (isHug){
            return hugHexMD5(originString + plusString);
        }
        return simpleHexMD5(originString + plusString);
    }


    // md5加密工具类，加密少量
    public static R simpleHexMD5(String originString) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance(Constant.DIGEST_TYPE);

            // 摘要内容
            byte[] digest = md.digest(originString.getBytes(Constant.CODING_TYPE));

            // 转换格式
            String md5String = converterBytesToHexString(digest);

            return R.ok().put(Constant.MD5_RESULT_NAME, md5String);

        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }


    // md5加密工具类，加密大量
    public static R hugHexMD5(String originString) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance(Constant.DIGEST_TYPE);

            // 如果内容比较多就用update，他会切割之后，循环来摘要
            md.update(originString.getBytes(Constant.CODING_TYPE));
            // 获取摘要
            byte[] digest = md.digest();
            // 转换
            String md5String = converterBytesToHexString(digest);

            return R.ok().put(Constant.MD5_RESULT_NAME, md5String);

        } catch (Exception e) {
            e.printStackTrace();
            return R.error();
        }
    }


    // 转换为十六进制字符串
    public static String converterBytesToHexString(byte[] digest){
        StringBuffer resultString = new StringBuffer();
        for (byte b : digest) {
            // 获取十六进制的字符串，与运算可以不要，md5是一个128位的字节数组，也就是16个字节，每个字节就是两个十六进制数字，可能会出现1-f，如果左边的为0，如果04，0f等，那么左边的0会丢失，因为无意义，所以需要手动添加
            String str = Integer.toHexString((int) b & 0xff);
            if (str.length() == 1){
                str = "0" + str;
            }
            resultString.append(str);
        }
        return resultString.toString();
    }



    public static void main(String[] args) {
        R haha = Md5Utils.plusHexMD5("haha", "true", true);
        System.out.println(haha.get(Constant.MD5_RESULT_NAME));
    }




}
