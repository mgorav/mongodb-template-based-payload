package com.gonnect.template.data.templatebasedpayload.document.enroll;

public enum Role {
    ADMIN("admin"),
    VIEW("view"),
    EDIT("edit")
    ;

    private final String code;

    private Role(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}
