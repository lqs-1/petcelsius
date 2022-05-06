package com.petcelsius.api.utils.security.digest;

import com.petcelsius.api.utils.security.converter.Converter;

import javax.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;


/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 信息摘要的工具类,md5.sha1,sha256.sha512,转换器有两种一个base64，一个hex（十六进制）,是不可逆的， 也就是不能解密
 * return 的是内部对象，数据转码成hex
 */
public class MessageDigestHexUtil {

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
    public static Encrypt doDigest(@NotNull String originString){

        return simpleDigest(originString);

    }



    // 普通方式, 默认使用md5，是否选择摘要大量数据
    public static Encrypt doDigest(@NotNull String originString, boolean isHug){

        if (isHug){

            return hugDigest(originString);

        }

        return simpleDigest(originString);

    }


    // 普通方式, 默认使用md5，是否选择摘要大量数据，并且选择使用的算法
    public static Encrypt doDigest(@NotNull String originString, DigestTypeSelector digestType, boolean isHug){

        if (isHug){

            return hugDigest(originString, digestType);

        }

        return simpleDigest(originString, digestType);

    }



    // 加盐方式,默认使用md5
    public static Encrypt doPlusDigest(@NotNull String originString, String plusString){

        return simpleDigest(originString + plusString);

    }



    // 加盐方式,默认使用md5,选择是否摘要大量数据
    public static Encrypt doPlusDigest(@NotNull String originString, @NotNull String plusString, boolean isHug){

        if (isHug){

            return hugDigest(originString + plusString);

        }

        return simpleDigest(originString + plusString);

    }



    // 加盐方式,默认使用md5,选择是否摘要大量数据,是否选择算法
    public static Encrypt doPlusDigest(@NotNull String originString, @NotNull String plusString, DigestTypeSelector digestType, boolean isHug){

        if (isHug){

            return hugDigest(originString + plusString, digestType);

        }

        return simpleDigest(originString + plusString, digestType);

    }



    // md5加密工具类，加密少量，使用md5算法，默认
    private static Encrypt simpleDigest(String originString) {

        try {

            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance(DIGEST_TYPE_MD);

            // 摘要内容
            byte[] digest = md.digest(originString.getBytes(CODING_TYPE));

            // 转换格式
            String md5String = Converter.converterBytesToHexString(digest);

            return new Encrypt(md5String);

        } catch (Exception e) {

            e.printStackTrace();

            return new Encrypt(null);

        }
    }



    // 指定算法名称的摘要
    private static Encrypt simpleDigest(String originString, DigestTypeSelector digestType) {

        try {

            // 生成一个对应算法加密计算摘要
            MessageDigest md = MessageDigest.getInstance(digestType.getTypeName());

            // 摘要内容
            byte[] digest = md.digest(originString.getBytes(CODING_TYPE));

            // 转换格式
            String md5String = Converter.converterBytesToHexString(digest);

            return new Encrypt(md5String);

        } catch (Exception e) {

            e.printStackTrace();

            return new Encrypt(null);

        }
    }



    // md5加密工具类，加密大量，也是md5的
    private static Encrypt hugDigest(String originString) {

        try {

            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance(DIGEST_TYPE_MD);

            // 如果内容比较多就用update，他会切割之后，循环来摘要
            md.update(originString.getBytes(CODING_TYPE));

            // 获取摘要
            byte[] digest = md.digest();

            // 转换
            String md5String = Converter.converterBytesToHexString(digest);

            return new Encrypt(md5String);

        } catch (Exception e) {

            e.printStackTrace();

            return new Encrypt(null);

        }
    }



    // md5加密工具类，加密大量，也是md5的
    private static Encrypt hugDigest(String originString, DigestTypeSelector digestType) {

        try {

            // 生成一个对应算法加密计算摘要
            MessageDigest md = MessageDigest.getInstance(digestType.getTypeName());

            // 如果内容比较多就用update，他会切割之后，循环来摘要
            md.update(originString.getBytes(CODING_TYPE));

            // 获取摘要
            byte[] digest = md.digest();

            // 转换
            String md5String = Converter.converterBytesToHexString(digest);

            return new Encrypt(md5String);

        } catch (Exception e) {

            e.printStackTrace();

            return new Encrypt(null);

        }
    }

    /**
     * 加密之后封装成此对象，此对象的getCode可以获取密文
     */

    public static class Encrypt{

        private String strCode;

        private Encrypt(String strCode){

            this.strCode = strCode;

        }

        public String getStrCode() {

            return strCode;

        }
    }
    

    // 工具测试
    public static void utilsTest(){

        String origin = "李奇凇";

        // 加密
        Encrypt encrypt = doDigest(origin, DigestTypeSelector.SHA_512, false);

        System.out.println("加密前=========>" + origin);

        System.out.println("加密后=========>" + encrypt.getStrCode());

    }

    public static void main(String[] args) {
        utilsTest();
    }

}
