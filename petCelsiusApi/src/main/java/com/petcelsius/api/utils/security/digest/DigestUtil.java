package com.petcelsius.api.utils.security.digest;

import com.petcelsius.api.constant.Constant;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.utils.security.converter.Converter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : md5的工具类,md5.sha1,sha256.sha512,转换器有两种一个base64，一个hex（十六进制）
 */
public class DigestUtil {

    // 信息加密的摘要方式，用于设置默认
    private static final String DIGEST_TYPE_MD = "MD5";

    // 编码类型
    private static final String CODING_TYPE = StandardCharsets.UTF_8.name();

    // 内部枚举,算法选择
    public enum DigestTypeSelector{

        MD5(1, "MD5"),

        SHA_1(2, "SHA-1"),

        SHA_256(3, "SHA-256"),

        SHA_512(4, "SHA-512");


        private Integer typeCode;

        private String typeName;


        DigestTypeSelector(Integer typeCode, String typeName){

            this.typeCode = typeCode;

            this.typeName = typeName;

        }


        public Integer getTypeCode() {
            return typeCode;
        }

        public String getTypeName() {
            return typeName;
        }

    }


    // 普通方式, 默认使用md5
    public static R doDigest(String originString){

        return simpleDigest(originString);

    }



    // 普通方式, 默认使用md5，是否选择摘要大量数据
    public static R doDigest(String originString, boolean isHug){

        if (isHug){

            return hugDigest(originString);

        }

        return simpleDigest(originString);

    }


    // 普通方式, 默认使用md5，是否选择摘要大量数据，并且选择使用的算法
    public static R doDigest(String originString, DigestTypeSelector digestType, boolean isHug){

        if (isHug){

            return hugDigest(originString, digestType);

        }

        return simpleDigest(originString, digestType);

    }



    // 加盐方式,默认使用md5
    public static R doPlusDigest(String originString, String plusString){

        return simpleDigest(originString + plusString);

    }



    // 加盐方式,默认使用md5,选择是否摘要大量数据
    public static R doPlusDigest(String originString, String plusString, boolean isHug){

        if (isHug){

            return hugDigest(originString + plusString);

        }

        return simpleDigest(originString + plusString);

    }



    // 加盐方式,默认使用md5,选择是否摘要大量数据,是否选择算法
    public static R doPlusDigest(String originString, String plusString, DigestTypeSelector digestType, boolean isHug){

        if (isHug){

            return hugDigest(originString + plusString, digestType);

        }

        return simpleDigest(originString + plusString, digestType);

    }



    // md5加密工具类，加密少量，使用md5算法，默认
    private static R simpleDigest(String originString) {

        try {

            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance(DIGEST_TYPE_MD);

            // 摘要内容
            byte[] digest = md.digest(originString.getBytes(CODING_TYPE));

            // 转换格式
            String md5String = Converter.converterBytesToBase64(digest);

            return R.ok().put(Constant.DIGEST_RESULT_NAME, md5String);

        } catch (Exception e) {

            e.printStackTrace();

            return R.error();

        }
    }



    // 指定算法名称的摘要
    private static R simpleDigest(String originString, DigestTypeSelector digestType) {

        try {

            // 生成一个对应算法加密计算摘要
            MessageDigest md = MessageDigest.getInstance(digestType.getTypeName());

            // 摘要内容
            byte[] digest = md.digest(originString.getBytes(CODING_TYPE));

            // 转换格式
            String digestString = Converter.converterBytesToBase64(digest);

            return R.ok().put(Constant.DIGEST_RESULT_NAME, digestString);

        } catch (Exception e) {

            e.printStackTrace();

            return R.error();

        }
    }



    // md5加密工具类，加密大量，也是md5的
    private static R hugDigest(String originString) {

        try {

            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance(DIGEST_TYPE_MD);

            // 如果内容比较多就用update，他会切割之后，循环来摘要
            md.update(originString.getBytes(CODING_TYPE));

            // 获取摘要
            byte[] digest = md.digest();

            // 转换
            String md5String = Converter.converterBytesToBase64(digest);

            return R.ok().put(Constant.DIGEST_RESULT_NAME, md5String);

        } catch (Exception e) {

            e.printStackTrace();

            return R.error();

        }
    }



    // md5加密工具类，加密大量，也是md5的
    private static R hugDigest(String originString, DigestTypeSelector digestType) {

        try {

            // 生成一个对应算法加密计算摘要
            MessageDigest md = MessageDigest.getInstance(digestType.getTypeName());

            // 如果内容比较多就用update，他会切割之后，循环来摘要
            md.update(originString.getBytes(CODING_TYPE));

            // 获取摘要
            byte[] digest = md.digest();

            // 转换
            String digestString = Converter.converterBytesToBase64(digest);

            return R.ok().put(Constant.DIGEST_RESULT_NAME, digestString);

        } catch (Exception e) {

            e.printStackTrace();

            return R.error();

        }
    }


    // 工具测试
    public static void utilsTest(){

        String origin = "李奇凇";

        // 加密
        R r = doDigest(origin, DigestTypeSelector.SHA_512, false);

        System.out.println("加密前=========>" + origin);

        System.out.println("加密后=========>" + r.get(Constant.DIGEST_RESULT_NAME));

    }

    public static void main(String[] args) {
        utilsTest();
    }

}
