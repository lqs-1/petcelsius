package com.petcelsius.api.utils.security.cipher.onekey;


import com.petcelsius.api.constant.Constant;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.utils.security.converter.Converter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 10:41
 * @do : 对称加密算法工具类，des和aes, 加密和解密使用同一个key
 */
public class OneKeyCipherUtils {

    // 编码类型
    private static final String CODING_TYPE = StandardCharsets.UTF_8.name();

    // 默认的key生成算法
    private static final String GENERATOR_KEY_ALGORITHM = "SHA1PRNG";

    // 加密状态码
    private static final Integer ENCRYPT_MODE = 1;

    // 解密状态码
    private static final Integer DECRYPT_MODE = 2;


    /**
     * 编写内部枚举，选择算法,填充模式，加密模式
     * 加密算法选择器
     * 解密算法，就了解两种，des和aes，des过时了，aes更好，des的key必须是8个字节，aes的key必须是16个字节
     * 加密模式，分为ECB（分块加密）和CBC（链式加密），ECB安全性没有CBC好，ECB一块一块加密，CBC是类似于一个链子，前一个加密好以后，后面的加密密钥会根据key和iv向量的异或值获得，安全性更好
     * 填充模式，分为PKCS5Padding和NoPadding，NoPadding在长度不够的时候不会自动填充，然后报错，PKCS5Padding在长度不够的时候会自动填充，长度是八个字节，八个字节的整数倍
     */
    public enum CipherTypeSelector{
        /**
         * 如果只是“DES”或者“AES”, 那么就默认是DES/ECB/PKCS5Padding或AES/ECB/PKCS5Padding，NoPadding狗都不用
         */

        DEFAULT_DES(1, "DES", "DES", 56), // DES/ECB/PKCS5Padding

        CBC_DES_PADDING(2, "DES/CBC/PKCS5Padding", "DES", 56),

        DEFAULT_AES(3, "AES", "AES", 128), // AES/ECB/PKCS5Padding

        CBC_AES_PADDING(4, "AES/CBC/PKCS5Padding", "AES", 128);


        private Integer cipherCode;

        private String cipherName;

        private String algorithmName;

        private Integer keyLength;


        CipherTypeSelector(Integer cipherCode, String cipherName, String algorithmName, Integer keyLength){

            this.cipherCode = cipherCode;

            this.cipherName = cipherName;

            this.algorithmName = algorithmName;

            this.keyLength = keyLength;

        }


        public Integer getCipherCode() {
            return cipherCode;
        }

        public String getCipherName() {
            return cipherName;
        }

        public String getAlgorithmName() {
            return algorithmName;
        }

        public Integer getKeyLength() {
            return keyLength;
        }
    }


    /**

     */
    /**
     * 根据给定的key生成新的key
     * 通过SHA1PRNG算法
     * @param cipherTypeSelector 用户选择的加密选项
     * @param key 用户传入的原始key
     * @return SecretKey 根据原始key生成的新key
     * @throws Exception
     */

    private static SecretKey generateSecretKey(CipherTypeSelector cipherTypeSelector, String key) throws Exception {

        // 根据传入的key生成一个唯一的指定长度的新key，这样就解决了非要给定一个指定长的key
        // 创建keyGenerator对象，传入加密算法的名字，可以根据传入的key生成对应算法名字的指定长度的新key
        KeyGenerator keyGenerator = KeyGenerator.getInstance(cipherTypeSelector.getAlgorithmName());

        // 初始化secureRandom， 并且指定生成指定长度key的算法
        SecureRandom secureRandom = SecureRandom.getInstance(GENERATOR_KEY_ALGORITHM);

        // 设置新key根据哪个种子（旧key）来生成
        secureRandom.setSeed(key.getBytes(CODING_TYPE));

        // 初始化生成key的对象，传入长度，再传入secureRandom
        keyGenerator.init(cipherTypeSelector.getKeyLength(), secureRandom);

        // 通过keyGenerator生成新的密钥
        SecretKey secretKey = keyGenerator.generateKey();

        return secretKey;
    }


    /**
     * 生成一个没有初始化的Cipher对象
     * @param cipherTypeSelector 用户选择的加密选项
     * @return 返回一个未初始化的cipher对象
     */

    private static Cipher generateCipher(CipherTypeSelector cipherTypeSelector) throws Exception{

        // 创建默认cipher对象
        // 获取加密解密对象,传入算法名称，填充模式和加密模式: 格式"算法/加密模式/填充模式", 也可以直接写算法，直接写算法，就等于"算法/ECB/KCS5Padding"
        Cipher cipher = Cipher.getInstance(cipherTypeSelector.getCipherName());

        // 返回对象
        return cipher;

    }


    /**
     * 生成一个Iv向量规范，再使用BCB加密模式的时候使用
     * @param secretKey 根据原始的key生成的新key
     * @return iv向量对象
     */

    private static IvParameterSpec generateIvParameterSpec(SecretKey secretKey){

        // 生成iv向量
        // 配置一个iv向量规范,传入新key的字节数组
        IvParameterSpec ivParameterSpec = new IvParameterSpec(secretKey.getEncoded());

        // 返回对象
        return ivParameterSpec;

    }


    /**
     * BCB加密模式的Cipher初始化
     * @param cipher 未被初始化的cipher对象
     * @param cipherMode cipher的模式，加密或者解密
     * @param secretKeySpec 密钥规范
     * @param ivParameterSpec iv向量规范
     * @return Cipher, 一个初始化好的对象
     */

    private static Cipher initCipher(Cipher cipher, Integer cipherMode, SecretKeySpec secretKeySpec, IvParameterSpec ivParameterSpec) throws Exception{

        // 初始化cipher
        // 添加cipher对象的处理方式  和   密钥规范  和iv向量规范
        cipher.init(cipherMode, secretKeySpec, ivParameterSpec);

        // 返回初始化好的cipher对象
        return cipher;

    }



    /**
     * ECB加密模式的Cipher初始化
     * @param cipher 未被初始化的cipher对象
     * @param cipherMode cipher的模式，加密或者解密
     * @param secretKeySpec 密钥规范
     * @return Cipher, 一个初始化好的对象
     */

    private static Cipher initCipher(Cipher cipher, Integer cipherMode, SecretKeySpec secretKeySpec) throws Exception{

        // 初始化cipher
        // 添加cipher对象的处理方式  和   密钥规范
        cipher.init(cipherMode, secretKeySpec);

        // 返回初始化好的cipher对象
        return cipher;
    }


    /**
     *
     * @param cipherTypeSelector 用户选择的加密选项
     * @param secretKey 根据原始的key生成的新key
     * @return 返回一个密钥规则对象
     */

    private static SecretKeySpec generateSecretKeySpec(CipherTypeSelector cipherTypeSelector, SecretKey secretKey){

        // 设置密钥规范,传入key的字节数组，还有机密算法，这个和上面的不一样，这个不能有填充模式和加密模式
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getEncoded(), cipherTypeSelector.getAlgorithmName());

        // 返回对象
        return secretKeySpec;
    }




    /**
     * 生成Cipher对象。模式，算法都是可以自己指定的
     * @param cipherTypeSelector 加密算法/加密/填充/ 选择
     * @param key 加密的key这个可以没有长度限制，这个方法会根据这个key生成一个新的key，这个key的长度根据cipherTypeSelector里面的参数来规定
     * @return Cipher 加密解密对象
     * @throws Exception
     */

    private static Cipher getCipher(CipherTypeSelector cipherTypeSelector, String key, Integer cipherMode) throws Exception {

        // 获取一个没有初始化的cipher对象
        Cipher cipher = generateCipher(cipherTypeSelector);

        // 根据原始的key获取一个新的key
        SecretKey secretKey = generateSecretKey(cipherTypeSelector, key);

        // 配置密钥规范
        SecretKeySpec secretKeySpec = generateSecretKeySpec(cipherTypeSelector, secretKey);

        // 如果使用的是CBC加密模式
        if (cipherTypeSelector.getCipherName().equals(CipherTypeSelector.CBC_AES_PADDING.getCipherName())
                || cipherTypeSelector.getCipherName().equals(CipherTypeSelector.CBC_DES_PADDING.getCipherName())){

            // 获取iv向量规范
            IvParameterSpec ivParameterSpec = generateIvParameterSpec(secretKey);

            // 初始化对象
            Cipher resultCipher = initCipher(cipher, cipherMode, secretKeySpec, ivParameterSpec);

            // 返回对象
            return resultCipher;

        }

        // ECB加密模式
            // 初始化对象
        Cipher resultCipher = initCipher(cipher, cipherMode, secretKeySpec);

            // 返回对象
        return resultCipher;

    }


    /**
     * 加密
     * @param origin 明文
     * @param key 原始key
     * @param cipherTypeSelector 加密方式选项
     * @return String 密文
     * @throws Exception
     */

    public static R encrypt(String origin, String key, CipherTypeSelector cipherTypeSelector) throws Exception {

        try{

            // 获取加密的cipher对象
            Cipher cipher = getCipher(cipherTypeSelector, key, ENCRYPT_MODE);

            // 获取加密后的字节数组
            byte[] bytes = cipher.doFinal(origin.getBytes());

            // 将字节数组转码
            String resultString = Converter.converterBytesToBase64(bytes);

            // 成功返回数据
            return R.ok().put(Constant.CIPHER_RESULT_NAME, resultString);

        }catch (Exception e){

            e.printStackTrace();

            // 失败返回错误信息
            return R.error();
        }
    }

    /**
     * 解密
     * @param origin 密文
     * @param key 原始key
     * @param cipherTypeSelector 解密方式选项，和加密方式选项一摸一样
     * @return String 明文
     * @throws Exception
     */

    public static R decrypt(String origin, String key, CipherTypeSelector cipherTypeSelector) throws Exception {

        try{

            // 获取加密对象
            Cipher cipher = getCipher(cipherTypeSelector, key, DECRYPT_MODE);

            // 将base64的密文转码为字节数组
            byte[] originBytes = Converter.converterBase64ToBytes(origin);

            // 将转换后的密文进行解码获取明文字节数组
            byte[] bytes = cipher.doFinal(originBytes);

            // 再将明文字节数组转码为字符串
            String resultString = new String(bytes);

            // 成功返回数据
            return R.ok().put(Constant.CIPHER_RESULT_NAME, resultString);

        }catch (Exception e){

            e.printStackTrace();

            // 失败返回错误信息
            return R.error();
        }


    }


    public static void utilsTest() throws Exception {

        // 加密
        R encrypt = encrypt("李奇凇", "liqisong", CipherTypeSelector.DEFAULT_DES);

        String code  = (String) encrypt.get(Constant.CIPHER_RESULT_NAME);

        System.out.println("加密后======> " + code);

        // 解密
        R decrypt = decrypt(code, "liqisong", CipherTypeSelector.DEFAULT_DES);

        String code1 = (String) decrypt.get(Constant.CIPHER_RESULT_NAME);

        System.out.println("解密后======> " + code1);

    }


    public static void main(String[] args) throws Exception {
        utilsTest();
    }
}
