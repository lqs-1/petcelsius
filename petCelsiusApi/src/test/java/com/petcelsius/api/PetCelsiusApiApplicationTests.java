package com.petcelsius.api;

import com.petcelsius.api.constant.Constant;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.utils.security.cipher.keypair.KeyPairCipherUtils;
import com.petcelsius.api.utils.security.cipher.onekey.OneKeyCipherUtils;
import org.junit.jupiter.api.Test;


class PetCelsiusApiApplicationTests {

    @Test
    void contextLoads() throws Exception {
        R encrypt = KeyPairCipherUtils.encrypt("李奇凇", KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_EN_PUBLIC);
        System.out.println(encrypt.get(Constant.CIPHER_RESULT_NAME));

        R decrypt = KeyPairCipherUtils.decrypt((String) encrypt.get(Constant.CIPHER_RESULT_NAME), KeyPairCipherUtils.CipherTypeSelector.ALGORITHM_DE_PRIVATE);
        System.out.println(decrypt.get(Constant.CIPHER_RESULT_NAME));

    }

}
