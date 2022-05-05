package com.petcelsius.api.utils.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 9:11
 * @do : 封装云通讯发送短信的配置信息
 */
@Data
@Component
@ConfigurationProperties(prefix = "rly.init")
public class SMSEntity {

    private String serverIp;

    private String serverPort;

    private String accountSId;

    private String accountToken;

    private String applicationId;


}


