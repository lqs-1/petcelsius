package com.petcelsius.api.utils.security.converter;

import org.apache.commons.codec.binary.Base64;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 10:02
 * @do : 返回摘要数据的转换器
 */
public class Converter {

    // 字节数组十六进制字符串, 只给消息摘要算法用
    public static String converterBytesToHexString(byte[] digest){
        StringBuffer resultString = new StringBuffer();
        for (byte b : digest) {
            // 获取十六进制的字符串，与运算可以不要，md5是一个128位的字节数组，也就是16个字节，每个字节就是两个十六进制数字，可能会出现1-f，如果左边的为0，如果04，0f等，那么左边的0会丢失，因为无意义，所以需要手动添加
            // &0xff是因为32位机器的一些原因
            String str = Integer.toHexString((int) b & 0xff);
            if (str.length() == 1){
                str = "0" + str;
            }
            resultString.append(str);
        }
        return resultString.toString();
    }


    // 转换为base64
    public static String converterBytesToBase64(byte[] digest){
        String resultString = Base64.encodeBase64String(digest);
        return resultString;
    }

    // base64转byte数组
    public static byte[] converterBase64ToBytes(String base64String){
        byte[] resultBytes = Base64.decodeBase64(base64String);
        return resultBytes;
    }

}
