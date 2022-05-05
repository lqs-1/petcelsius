package com.petcelsius.api.utils;



import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.petcelsius.api.constant.Constant;
import com.petcelsius.api.constant.MessageConstant;
import com.petcelsius.api.utils.entity.SMSEntity;
import org.springframework.beans.factory.annotation.Value;


import java.util.HashMap;
import java.util.Set;


/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 发送短信工具类,需要启动spring容器
 */
public class SMSUtils {

    /**
     * 发送短信
     *
     * @param phoneNumbers
     * @param param
     * @param smsEntity
     * @return
     * @throws
     */

    public static Result sendShortMessage(String phoneNumbers, String param, SMSEntity smsEntity) {

        CCPRestSmsSDK sdk = getCcpRestSmsSDK(smsEntity);

        String to = phoneNumbers;
        String templateId = Constant.SMS_TEMPLATE_BY_RLY_ID;
        String[] datas = {param, "5"};

        HashMap<String, Object> result = sdk.sendTemplateSMS(to, templateId, datas);

        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for (String key : keySet) {
                Object object = data.get(key);
                System.out.println(key + " = " + object);
            }
            return new Result(true, MessageConstant.SEND_VALIDATECODE_SUCCESS);

        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
            return new Result(false, MessageConstant.SEND_VALIDATECODE_FAIL);
        }

    }

    // 创建发送短信的对象
    private static CCPRestSmsSDK getCcpRestSmsSDK(SMSEntity smsEntity) {
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(smsEntity.getServerIp(), smsEntity.getServerPort());
        sdk.setAccount(smsEntity.getAccountSId(), smsEntity.getAccountToken());
        sdk.setAppId(smsEntity.getApplicationId());
        sdk.setBodyType(BodyType.Type_JSON);
        return sdk;
    }

}