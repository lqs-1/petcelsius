package com.petcelsius.api;

import com.petcelsius.api.constant.Constant;
import com.petcelsius.api.utils.R;
import com.petcelsius.api.utils.security.cipher.onekey.OneKeyCipherUtils;
import org.junit.jupiter.api.Test;


class PetCelsiusApiApplicationTests {

    @Test
    void contextLoads() throws Exception {
        OneKeyCipherUtils.utilsTest();
    }

}
