package com.petcelsius.api.utils.security.cipher.keypair;

import com.petcelsius.api.constant.Constant;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.utils.security.converter.Converter;
import org.apache.commons.io.FileUtils;

import javax.crypto.Cipher;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 16:32
 * @do : RSA加密，非对称加密， 如果使用公钥加密，那么就必须使用私钥解密，反之也是
 */


public class KeyPairCipherUtils {

    /**
     * 一般来说公约用于加密，原因如下：
     *  私钥是不公开的，公钥是公开的，如果一个公司使用私钥加密，那么这个公司所有的员工都可以解密，是不安全的
     *  如果使用公钥加密，然后因为公钥是公开的，私钥是不公开的，就会安全很多
     *
     *  另外，我发现一点，如果使用私钥多次加密同一个明文，那么得到的始终是同一个密文
     *                如果使用公钥多次加密，就会发现每次的密文都不一样，不知道为什么
     *                但是每一个公钥加密的明文都可以用私钥解密
     */

    // 字符编码
    private static final String CODING_TYPE =StandardCharsets.UTF_8.name();

    // 公钥类型名字（判定时候用）
    private static final String PUBLIC_TYPE = "PUBLIC";

    // 私钥类型名字（判定时候用）
    private static final String PRIVATE_TYPE = "PRIVATE";

    // 公钥文件名
    private static final String PUBLIC_KEY_FILE_NAME = "public.pem";

    // 私钥文件名
    private static final String PRIVATE_KEY_FILE_NAME = "private.pem";

    // 加密状态码
    private static final Integer ENCRYPT_MODE = 1;

    // 解密状态码
    private static final Integer DECRYPT_MODE = 2;



    /**
     * 在使用非对称加密的时候，和对称加密最大的不同就是，对称加密在创建加密解密对象的时候，需要传递的是算法/加密模式/填充模式，而非对称加密只需传递一个算法，不需要iv向量规范和密钥规范
     *  在使用非对称加密的时候，先通过密钥对生成器生成一对公钥密钥，然后在初始化cipher对象的时候，第二个参数传入的是 使用的公钥或者私钥， 如果加密公钥，那么解密就要用私钥， 反之相同
     *  其他的和对称加密是一样的
     *  这个工具类需要依赖
     *      <dependency>
     *         <groupId>commons-io</groupId>
     *         <artifactId>commons-io</artifactId>
     *         <version>2.6</version>
     *       </dependency>
     *   来文件读写
     * @throws Exception
     */

    public enum CipherTypeSelector{

        /**
         * 使用RSA的时候的枚举变量
         */

        ALGORITHM_EN_PRIVATE( "RSA", "PRIVATE", "PUBLIC"),

        ALGORITHM_EN_PUBLIC( "RSA", "PUBLIC", "PRIVATE"),

        ALGORITHM_DE_PRIVATE( "RSA", "PUBLIC", "PRIVATE"),

        ALGORITHM_DE_PUBLIC( "RSA", "PRIVATE", "PUBLIC");


        private String algorithmName;

        private String encryptKey;

        private String decryptKey;



        CipherTypeSelector(String algorithmName, String encryptKey, String decryptKey){

            this.algorithmName = algorithmName;

            this.encryptKey = encryptKey;

            this.decryptKey = decryptKey;

        }


        public String getAlgorithmName() {
            return algorithmName;
        }

        public String getEncryptKey() {
            return encryptKey;
        }

        public String getDecryptKey() {
            return decryptKey;
        }

    }


    /**
     * 生成密钥对，根据算法选项中的算法名
     * @param cipherTypeSelector 算法选项
     * @return KeyPair 密钥对
     * @throws Exception
     */

    private static KeyPair generateKeyPair(CipherTypeSelector cipherTypeSelector) throws Exception{

        // 获取密钥对生成器对象，传入的是算法的名字，这里是非对称加密的密钥对生成器
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(cipherTypeSelector.getAlgorithmName());

        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // 保存密钥对
        saveKeyPair(keyPair);

        // 返回密钥对对象
        return keyPair;

    }


    /**
     * 保存密钥对
     * @param keyPair 生成好的密钥对
     */

    private static void saveKeyPair(KeyPair keyPair) throws Exception{

        // 获取公钥
        PublicKey publicKey = keyPair.getPublic();

        // 获取私钥
        PrivateKey privateKey = keyPair.getPrivate();

        // 获取公钥字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();

        // 获取私钥钥字节数组
        byte[] privateKeyEncoded = privateKey.getEncoded();


        // 保存公钥
        FileUtils.writeStringToFile(new File(PUBLIC_KEY_FILE_NAME), Converter.converterBytesToBase64(publicKeyEncoded),CODING_TYPE);

        // 保存私钥
        FileUtils.writeStringToFile(new File(PRIVATE_KEY_FILE_NAME), Converter.converterBytesToBase64(privateKeyEncoded), CODING_TYPE);

    }


    /**
     * 读取私钥文件
     * @param cipherTypeSelector 算法选项
     * @return privateKey对象
     * @throws Exception
     */

    private static PrivateKey getPrivateKey(CipherTypeSelector cipherTypeSelector) throws Exception{

        // 读取保存的私钥文件
        String privateKeyString = FileUtils.readFileToString(new File(PRIVATE_KEY_FILE_NAME), CODING_TYPE);

        // 将私钥字符串转换为privateKey对象
            // 创建key工厂对象，传入算法名字
        KeyFactory keyFactory = KeyFactory.getInstance(cipherTypeSelector.getAlgorithmName());

            // 创建私钥key的规则
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Converter.converterBase64ToBytes(privateKeyString));

            // 生成privateKey对象
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // 返回对象
        return privateKey;

    }


    /**
     * 读取公钥文件
     * @param cipherTypeSelector 算法选项
     * @return publicKey对象
     * @throws Exception
     */

    private static PublicKey getPublicKey(CipherTypeSelector cipherTypeSelector) throws Exception{

        // 读取保存的公钥文件
        String privateKeyString = FileUtils.readFileToString(new File(PUBLIC_KEY_FILE_NAME), CODING_TYPE);

        // 将公钥字符串转换为publicKey对象
            // 创建key工厂对象, 传入算法名字
        KeyFactory keyFactory = KeyFactory.getInstance(cipherTypeSelector.getAlgorithmName());

            // 创建公钥key的规则
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Converter.converterBase64ToBytes(privateKeyString));
            // 生成publicKey对象
        PublicKey publicKey = keyFactory.generatePublic(keySpec);

        // 返回对象
        return publicKey;

    }


    /**
     * 创建一个初始化好的cipher对象
     * @param cipherTypeSelector 算法选项
     * @param key key（私钥或者公钥）
     * @param cipherMode 操作模式。加密或者解密
     * @return Cipher对象
     * @throws Exception
     */

    private static Cipher getCipher(CipherTypeSelector cipherTypeSelector, Key key, Integer cipherMode) throws Exception{

        // 创建加密对象
        Cipher cipher = Cipher.getInstance(cipherTypeSelector.getAlgorithmName());

        // 对加密进行初始化
        // 第一个参数： cipher的模式
        // 第二个参数： 你想使用公钥加密还是私钥加密, 是一个公钥或者私钥的对象
        // 使用私钥加密
        cipher.init(cipherMode, key);

        // 返回对象
        return cipher;
    }


    /**
     * 加密
     * @param origin 明文
     * @param cipherTypeSelector 加密选项
     * @return Encrypt 对象
     * @throws Exception
     */

    public static Encrypt encrypt(@NotNull String origin, CipherTypeSelector cipherTypeSelector) throws Exception {

        /**
         * 读取文件中的公钥或者私钥进行加密
         * 没有这个文件就会出现异常，在出现异常的时候，生成密钥对，然后进行操作
         */

        try {

            // 用来存放读取出来的用来key
            Key key = null;

            // 根据用户算法选项来决定用哪个密钥加密
            if (cipherTypeSelector.getEncryptKey().equals(PUBLIC_TYPE)) {

                // 读取文件中的publicKey
                key = getPublicKey(cipherTypeSelector);

            } else if (cipherTypeSelector.getEncryptKey().equals(PRIVATE_TYPE)) {

                // 读取文件中的privateKey
                key = getPrivateKey(cipherTypeSelector);

            }

            // 获取cipher对象
            Cipher cipher = getCipher(cipherTypeSelector, key, ENCRYPT_MODE);

            // 加密之后获取到字节数组
            byte[] bytes = cipher.doFinal(origin.getBytes(CODING_TYPE));

            // 转码
            String resultString = Converter.converterBytesToBase64(bytes);

            // 加密后返回密文
            // return R.ok().put(Constant.CIPHER_RESULT_NAME, resultString);
            return new Encrypt(resultString);

        } catch (Exception e) {

            /**
             * 没有密钥对文件，那么就生成密钥对然后加密，然后保存密钥对
             */

            // 生成密钥对
            KeyPair keyPair = generateKeyPair(cipherTypeSelector);

            // 用来存放读取出来的用来key
            Key key = null;

            // 根据用户算法选项来决定用哪个密钥加密
            if (cipherTypeSelector.getEncryptKey().equals(PUBLIC_TYPE)) {

                // 从生成的密钥对中获取publicKey
                key = keyPair.getPublic();

            } else if (cipherTypeSelector.getEncryptKey().equals(PRIVATE_TYPE)) {

                // 从生成的密钥对中获取privateKey
                key = keyPair.getPrivate();

            }

            // 获取cipher对象
            Cipher cipher = getCipher(cipherTypeSelector, key, ENCRYPT_MODE);

            // 加密之后获取到字节数组
            byte[] bytes = cipher.doFinal(origin.getBytes(CODING_TYPE));

            // 转码
            String resultString = Converter.converterBytesToBase64(bytes);

            // 加密后返回密文
            // return R.ok().put(Constant.CIPHER_RESULT_NAME, resultString) ;
            return new Encrypt(resultString);

        }

    }


    /**
     * 加密
     * @param origin 明文
     * @param cipherTypeSelector 加密选项
     * @return R 对象
     * @throws Exception
     */

    public static R encryption(@NotNull String origin, CipherTypeSelector cipherTypeSelector) throws Exception {

        /**
         * 读取文件中的公钥或者私钥进行加密
         * 没有这个文件就会出现异常，在出现异常的时候，生成密钥对，然后进行操作
         */

        try {

            // 用来存放读取出来的用来key
            Key key = null;

            // 根据用户算法选项来决定用哪个密钥加密
            if (cipherTypeSelector.getEncryptKey().equals(PUBLIC_TYPE)) {

                // 读取文件中的publicKey
                key = getPublicKey(cipherTypeSelector);

            } else if (cipherTypeSelector.getEncryptKey().equals(PRIVATE_TYPE)) {

                // 读取文件中的privateKey
                key = getPrivateKey(cipherTypeSelector);

            }

            // 获取cipher对象
            Cipher cipher = getCipher(cipherTypeSelector, key, ENCRYPT_MODE);

            // 加密之后获取到字节数组
            byte[] bytes = cipher.doFinal(origin.getBytes(CODING_TYPE));

            // 转码
            String resultString = Converter.converterBytesToBase64(bytes);

            // 加密后返回密文
            return R.ok().put(Constant.CIPHER_RESULT_NAME, resultString);

        } catch (Exception e) {

            /**
             * 没有密钥对文件，那么就生成密钥对然后加密，然后保存密钥对
             */

            // 生成密钥对
            KeyPair keyPair = generateKeyPair(cipherTypeSelector);

            // 用来存放读取出来的用来key
            Key key = null;

            // 根据用户算法选项来决定用哪个密钥加密
            if (cipherTypeSelector.getEncryptKey().equals(PUBLIC_TYPE)) {

                // 从生成的密钥对中获取publicKey
                key = keyPair.getPublic();

            } else if (cipherTypeSelector.getEncryptKey().equals(PRIVATE_TYPE)) {

                // 从生成的密钥对中获取privateKey
                key = keyPair.getPrivate();

            }

            // 获取cipher对象
            Cipher cipher = getCipher(cipherTypeSelector, key, ENCRYPT_MODE);

            // 加密之后获取到字节数组
            byte[] bytes = cipher.doFinal(origin.getBytes(CODING_TYPE));

            // 转码
            String resultString = Converter.converterBytesToBase64(bytes);

            // 加密后返回密文
            return R.ok().put(Constant.CIPHER_RESULT_NAME, resultString) ;

        }

    }


    /**
     * 解密
     * @param origin 密文
     * @return Decrypt 对象
     * @param cipherTypeSelector 算法选项
     */

    public static Decrypt decrypt(@NotNull String origin, CipherTypeSelector cipherTypeSelector){

        /**
         * 读取文件中的公钥或者私钥进行解密
         * 没有这个文件就会出现异常，然后直接返回， 不再处理
         */

        try {

            // 用来存放读取出来的用来key
            Key key = null;

            // 根据用户算法选项来决定用哪个密钥解密
            if (cipherTypeSelector.getDecryptKey().equals(PUBLIC_TYPE)) {

                // 读取文件中的publicKey
                key = getPublicKey(cipherTypeSelector);

            } else if (cipherTypeSelector.getDecryptKey().equals(PRIVATE_TYPE)) {

                // 读取文件中的privateKey
                key = getPrivateKey(cipherTypeSelector);

            }

            // 获取cipher对象
            Cipher cipher = getCipher(cipherTypeSelector, key, DECRYPT_MODE);

            // 解密获取到字节数组
            byte[] bytes = cipher.doFinal(Converter.converterBase64ToBytes(origin));

            // 转码
            String resultString = new String(bytes);

            // 返回数据，解密后的明文
            // return R.ok().put(Constant.CIPHER_RESULT_NAME, resultString) ;
            return new Decrypt(resultString);

        } catch (Exception e) {

            /**
             * 没有密钥对文件，直接返回
             */

            e.printStackTrace();

            // 返回错误信息
            // return R.error();
            return new Decrypt(null);

        }

    }


    /**
     * 解密
     * @param origin 密文
     * @return R 对象
     * @param cipherTypeSelector 算法选项
     */

    public static R decryption(@NotNull String origin, CipherTypeSelector cipherTypeSelector){

        /**
         * 读取文件中的公钥或者私钥进行解密
         * 没有这个文件就会出现异常，然后直接返回， 不再处理
         */

        try {

            // 用来存放读取出来的用来key
            Key key = null;

            // 根据用户算法选项来决定用哪个密钥解密
            if (cipherTypeSelector.getDecryptKey().equals(PUBLIC_TYPE)) {

                // 读取文件中的publicKey
                key = getPublicKey(cipherTypeSelector);

            } else if (cipherTypeSelector.getDecryptKey().equals(PRIVATE_TYPE)) {

                // 读取文件中的privateKey
                key = getPrivateKey(cipherTypeSelector);

            }

            // 获取cipher对象
            Cipher cipher = getCipher(cipherTypeSelector, key, DECRYPT_MODE);

            // 解密获取到字节数组
            byte[] bytes = cipher.doFinal(Converter.converterBase64ToBytes(origin));

            // 转码
            String resultString = new String(bytes);

            // 返回数据，解密后的明文
            return R.ok().put(Constant.CIPHER_RESULT_NAME, resultString) ;

        } catch (Exception e) {

            /**
             * 没有密钥对文件，直接返回
             */

            e.printStackTrace();

            // 返回错误信息
            return R.error();

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


    /**
     * 解密之后封装成此对象，此对象的getCode可以获取明文
     */

    public static class Decrypt{

        private String strCode;

        private Decrypt(String strCode){

            this.strCode = strCode;

        }

        public String getStrCode() {

            return strCode;

        }
    }





    /**
     * 测试
     * @throws Exception
     */
    public static void utilsTest() throws Exception{

        // 加密数据
        Encrypt encrypt = encrypt("李奇凇今天的天气不错", CipherTypeSelector.ALGORITHM_EN_PRIVATE);

        String code  = encrypt.getStrCode();

        System.out.println("加密后========>" + code);

        // 解密数据
        Decrypt decrypt = decrypt(code, CipherTypeSelector.ALGORITHM_EN_PRIVATE);

        String code1  = decrypt.getStrCode();

        System.out.println("加密前========>" + code1);

    }


    public static void main(String[] args) throws Exception {
        utilsTest();
    }

}
