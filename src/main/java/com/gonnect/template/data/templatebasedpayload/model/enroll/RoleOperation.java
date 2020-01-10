package com.gonnect.template.data.templatebasedpayload.model.enroll;

public enum RoleOperation {
    POST("post"),
    PUT("put"),
    DELETE("delete"),
    GET("get"),
    PATCH("patch")
    ;

    private final String code;

    private RoleOperation(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
