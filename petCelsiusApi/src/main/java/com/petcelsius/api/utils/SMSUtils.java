package com.petcelsius.api.utils;



import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;


import java.util.HashMap;
import java.util.Set;

/**
 * 短信发送工具类
 */
public class SMSUtils {

    /**
     * 发送短信
     *
     * @param phoneNumbers
     * @param param
     * @return
     * @throws
     */
    public static Result sendShortMessage(String phoneNumbers, String param) {
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "8a216da87ca23458017cd12b56d008d1";
        String accountToken = "a4837f29b26d4a9380c516e5e0320e0b";
        //请使用管理控制台中已创建应用的APPID
        String appId = "8a216da87ca23458017cd12b57ce08d8";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        String to = phoneNumbers;
        String templateId = "1";
        String[] datas = {param, "5"};
//		String subAppend="1234";  //可选 扩展码，四位数字 0~9999
//		String reqId="fadfafas";  //可选 第三方自定义消息id，最大支持32位英文数字，同账号下同一自然天内不允许重复
        HashMap<String, Object> result = sdk.sendTemplateSMS(to, templateId, datas);
//		HashMap<String, Object> result = sdk.sendTemplateSMS(to,templateId,datas,"","");
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

    public static void main(String[] args) {
        SMSUtils.sendShortMessage("17398827615", "1234");
    }
}