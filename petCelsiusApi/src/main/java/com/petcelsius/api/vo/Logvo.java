package com.petcelsius.api.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Logvo {
    @NotBlank
    private String mobile;
    @NotBlank
    private String smsCode;
}
