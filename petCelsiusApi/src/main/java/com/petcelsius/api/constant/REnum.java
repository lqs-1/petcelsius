package com.petcelsius.api.constant;

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
