package com.petcelsius.api.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginByEmailVo {
    // TODO 继续完善

    @NotBlank
    private String email;
    @NotBlank
    private String emailCode;
}
