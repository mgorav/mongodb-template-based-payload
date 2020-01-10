package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class UserDefinition {
    @Id
    private String _id;

    public UserDefinition() {
        _id = UUID.randomUUID().toString();
    }
}
