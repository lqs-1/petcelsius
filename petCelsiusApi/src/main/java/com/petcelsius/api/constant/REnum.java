package com.petcelsius.api.constant;

/**
 * @author : 李奇凇
 * @date : 2022/5/5 8:46
 * @do : 相应对象默认状态码和状态信息的枚举
 */
public enum REnum {

    SUCCESS(0, "success"),
    FAIL(1, "fail");

    private Integer statusCode;
    private String statusMsg;

    REnum(Integer statusCode, String statusMsg){
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }
}
