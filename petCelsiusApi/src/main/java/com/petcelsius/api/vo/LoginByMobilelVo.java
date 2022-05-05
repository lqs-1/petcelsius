package com.petcelsius.api.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 9:11
 * @do : 封装登录信息（短信方式）
 */
@Data
public class LoginByMobilelVo {
    // TODO 继续完善

    @NotBlank
    private String mobile;
    @NotBlank
    private String smsCode;

}
