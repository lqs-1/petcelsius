package com.petcelsius.api;

import com.petcelsius.api.constant.Constant;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.utils.security.cipher.keypair.KeyPairCipherUtils;
import com.petcelsius.api.utils.security.cipher.onekey.OneKeyCipherUtils;
import com.petcelsius.api.utils.security.digest.MessageDigestBase64Util;
import com.petcelsius.api.utils.security.digest.MessageDigestHexUtil;
import org.junit.jupiter.api.Test;


/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 加密工具类测试
 */
class SecurityUtilsTest {

    @Test
    void digestTest() throws Exception {

        // 明文
        String origin = "李奇凇又是忙了一个下午";

        // 消息摘要测试

        R digest1 = MessageDigestBase64Util.doDigest(origin);
        R digest2 = MessageDigestBase64Util.doDigest(origin, true);
        R digest3 = MessageDigestBase64Util.doDigest(origin, false);
        R digest4 = MessageDigestBase64Util.doDigest(origin, MessageDigestBase64Util.DigestTypeSelector.SHA_256, true);
        R digest5 = MessageDigestBase64Util.doDigest(origin, MessageDigestBase64Util.DigestTypeSelector.SHA_256, false);

        R plus1 = MessageDigestBase64Util.doPlusDigest(origin, origin);
        R plus2 = MessageDigestBase64Util.doPlusDigest(origin, origin, true);
        R plus3 = MessageDigestBase64Util.doPlusDigest(origin, origin, false);
        R plus4 = MessageDigestBase64Util.doPlusDigest(origin, origin, MessageDigestBase64Util.DigestTypeSelector.SHA_512, true);
        R plus5 = MessageDigestBase64Util.doPlusDigest(origin, origin, MessageDigestBase64Util.DigestTypeSelector.SHA_512,false);

        System.out.println(digest1);
        System.out.println(digest2);
        System.out.println(digest3);
        System.out.println(digest4);
        System.out.println(digest5);

        System.out.println(plus1);
        System.out.println(plus2);
        System.out.println(plus3);
        System.out.println(plus4);
        System.out.println(plus5);

    }


    @Test
    void MessageDigestTest() throws Exception {

        // 明文
        String origin = "李奇凇又是忙了一个下午";

        // 消息摘要测试

        MessageDigestHexUtil.Encrypt digest1 = MessageDigestHexUtil.doDigest(origin);
        MessageDigestHexUtil.Encrypt digest2 = MessageDigestHexUtil.doDigest(origin, true);
        MessageDigestHexUtil.Encrypt digest3 = MessageDigestHexUtil.doDigest(origin, false);
        MessageDigestHexUtil.Encrypt digest4 = MessageDigestHexUtil.doDigest(origin, MessageDigestHexUtil.DigestTypeSelector.SHA_256, true);
        MessageDigestHexUtil.Encrypt digest5 = MessageDigestHexUtil.doDigest(origin, MessageDigestHexUtil.DigestTypeSelector.SHA_256, false);

        MessageDigestHexUtil.Encrypt plus1 = MessageDigestHexUtil.doPlusDigest(origin, origin);
        MessageDigestHexUtil.Encrypt plus2 = MessageDigestHexUtil.doPlusDigest(origin, origin, true);
        MessageDigestHexUtil.Encrypt plus3 = MessageDigestHexUtil.doPlusDigest(origin, origin, false);
        MessageDigestHexUtil.Encrypt plus4 = MessageDigestHexUtil.doPlusDigest(origin, origin, MessageDigestHexUtil.DigestTypeSelector.SHA_512, true);
        MessageDigestHexUtil.Encrypt plus5 = MessageDigestHexUtil.doPlusDigest(origin, origin, MessageDigestHexUtil.DigestTypeSelector.SHA_512,false);

        System.out.println(digest1.getStrCode());
        System.out.println(digest2.getStrCode());
        System.out.println(digest3.getStrCode());
        System.out.println(digest4.getStrCode());
        System.out.println(digest5.getStrCode());

        System.out.println(plus1.getStrCode());
        System.out.println(plus2.getStrCode());
        System.out.println(plus3.getStrCode());
        System.out.println(plus4.getStrCode());
        System.out.println(plus5.getStrCode());

    }


    @Test
    void OneKeyTest() throws Exception {

        // 明文
        String origin = "李奇凇又是忙了一个下午";
        String key = "李奇凇";

        // 对称加密测试

        R encryption1 = OneKeyCipherUtils.encryption(origin, key, OneKeyCipherUtils.CipherTypeSelector.DEFAULT_DES);
        R encryption2 = OneKeyCipherUtils.encryption(origin, key, OneKeyCipherUtils.CipherTypeSelector.DEFAULT_AES);
        R encryption3 = OneKeyCipherUtils.encryption(origin, key, OneKeyCipherUtils.CipherTypeSelector.CBC_DES_PADDING);
        R encryption4 = OneKeyCipherUtils.encryption(origin, key, OneKeyCipherUtils.CipherTypeSelector.CBC_AES_PADDING);

        System.out.println(encryption1);
        System.out.println(encryption2);
        System.out.println(encryption3);
        System.out.println(encryption4);

        OneKeyCipherUtils.Encrypt encrypt1 = OneKeyCipherUtils.encrypt(origin, key, OneKeyCipherUtils.CipherTypeSelector.DEFAULT_DES);
        OneKeyCipherUtils.Encrypt encrypt2 = OneKeyCipherUtils.encrypt(origin, key, OneKeyCipherUtils.CipherTypeSelector.DEFAULT_AES);
        OneKeyCipherUtils.Encrypt encrypt3 = OneKeyCipherUtils.encrypt(origin, key, OneKeyCipherUtils.CipherTypeSelector.CBC_DES_PADDING);
        OneKeyCipherUtils.Encrypt encrypt4 = OneKeyCipherUtils.encrypt(origin, key, OneKeyCipherUtils.CipherTypeSelector.CBC_AES_PADDING);

        System.out.println(encrypt1.getStrCode());
        System.out.println(encrypt2.getStrCode());
        System.out.println(encrypt3.getStrCode());
        System.out.println(encrypt4.getStrCode());

        R dncryption1 = OneKeyCipherUtils.decryption((String) encryption1.get(Constant.CIPHER_RESULT_NAME), key, OneKeyCipherUtils.CipherTypeSelector.DEFAULT_DES);
        R dncryption2 = OneKeyCipherUtils.decryption((String) encryption2.get(Constant.CIPHER_RESULT_NAME), key, OneKeyCipherUtils.CipherTypeSelector.DEFAULT_AES);
        R dncryption3 = OneKeyCipherUtils.decryption((String) encryption3.get(Constant.CIPHER_RESULT_NAME), key, OneKeyCipherUtils.CipherTypeSelector.CBC_DES_PADDING);
        R dncryption4 = OneKeyCipherUtils.decryption((String) encryption4.get(Constant.CIPHER_RESULT_NAME), key, OneKeyCipherUtils.CipherTypeSelector.CBC_AES_PADDING);

        System.out.println(dncryption1);
        System.out.println(dncryption2);
        System.out.println(dncryption3);
        System.out.println(dncryption4);

        OneKeyCipherUtils.Decrypt dncrypt1 = OneKeyCipherUtils.decrypt(encrypt1.getStrCode(), key, OneKeyCipherUtils.CipherTypeSelector.DEFAULT_DES);
        OneKeyCipherUtils.Decrypt dncrypt2 = OneKeyCipherUtils.decrypt(encrypt2.getStrCode(), key, OneKeyCipherUtils.CipherTypeSelector.DEFAULT_AES);
        OneKeyCipherUtils.Decrypt dncrypt3 = OneKeyCipherUtils.decrypt(encrypt3.getStrCode(), key, OneKeyCipherUtils.CipherTypeSelector.CBC_DES_PADDING);
        OneKeyCipherUtils.Decrypt dncrypt4 = OneKeyCipherUtils.decrypt(encrypt4.getStrCode(), key, OneKeyCipherUtils.CipherTypeSelector.CBC_AES_PADDING);

        System.out.println(dncrypt1.getStrCode());
        System.out.println(dncrypt2.getStrCode());
        System.out.println(dncrypt3.getStrCode());
        System.out.println(dncrypt4.getStrCode());

    }



    @Test
    void KeyPairTest() throws Exception {

        // 明文
        String origin = "李奇凇又是忙了一个下午";

        // 非对称加密测试

        R encryption1 = KeyPairCipherUtils.encryption(origin, KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_EN_PRIVATE);
        R encryption2 = KeyPairCipherUtils.encryption(origin, KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_EN_PUBLIC);

        System.out.println(encryption1);
        System.out.println(encryption2);

        KeyPairCipherUtils.Encrypt encrypt1 = KeyPairCipherUtils.encrypt(origin, KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_EN_PRIVATE);
        KeyPairCipherUtils.Encrypt encrypt2 = KeyPairCipherUtils.encrypt(origin, KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_EN_PUBLIC);

        System.out.println(encrypt1.getStrCode());
        System.out.println(encrypt2.getStrCode());

        R decryption1 = KeyPairCipherUtils.decryption((String) encryption1.get(Constant.CIPHER_RESULT_NAME), KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_DE_PUBLIC);
        R decryption2 = KeyPairCipherUtils.decryption((String) encryption2.get(Constant.CIPHER_RESULT_NAME), KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_DE_PRIVATE);

        System.out.println(decryption1);
        System.out.println(decryption2);

        KeyPairCipherUtils.Decrypt decrypt1 = KeyPairCipherUtils.decrypt(encrypt1.getStrCode(), KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_DE_PUBLIC);
        KeyPairCipherUtils.Decrypt decrypt2 = KeyPairCipherUtils.decrypt(encrypt2.getStrCode(), KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_DE_PRIVATE);

        System.out.println(decrypt1.getStrCode());
        System.out.println(decrypt2.getStrCode());

    }
}
