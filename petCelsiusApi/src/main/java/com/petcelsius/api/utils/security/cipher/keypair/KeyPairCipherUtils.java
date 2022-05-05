package com.petcelsius.api.utils.security.cipher.keypair;

import com.petcelsius.api.constant.Constant;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 16:32
 * @do : RSA加密，非对称加密， 如果使用公钥加密，那么就必须使用私钥解密，反之也是
 */

public class KeyPairCipherUtils {

    private static final String CODING_TYPE =StandardCharsets.UTF_8.name();






    public static void generateKeyPair() throws Exception{
        String input = "haha";
        // 创建密钥对
        // KeyPairGenerator： 密钥对象生成
        String algorithm = "RSA";
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        // 生成密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // 获取私钥
        PrivateKey privateKey = keyPair.getPrivate();
        // 获取公钥
        PublicKey publicKey = keyPair.getPublic();



        // 获取私钥的字节数组
        byte[] privateKeyEncoded = privateKey.getEncoded();
        // 获取公钥字节数组
        byte[] publicKeyEncoded = publicKey.getEncoded();

        // base64转码
        String privateBase64Key = Base64.encodeBase64String(privateKeyEncoded);
        String publicBase64Key = Base64.encodeBase64String(publicKeyEncoded);

        // 打印公钥和私钥
        System.out.println("private======>" + privateBase64Key);
        System.out.println("public======>" + publicBase64Key);



        // 创建加密对象
        Cipher cipher = Cipher.getInstance(algorithm);
        // 对加密进行初始化
        // 第一个参数： cipher的模式
        // 第二个参数： 你想使用公钥加密还是私钥加密, 是一个公钥或者私钥的对象
        // 使用私钥加密
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);

        // 对明文加密
        byte[] bytes = cipher.doFinal(input.getBytes(CODING_TYPE));
    }


    public static void main(String[] args) throws Exception {
        generateKeyPair();
    }

}
