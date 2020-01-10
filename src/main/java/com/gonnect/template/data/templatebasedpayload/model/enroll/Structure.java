package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Map;
import java.util.UUID;

@Data
public class Structure {
    @Id
    private String _id;
    private String columnName;
    private String validationModule;
    private boolean isPk;

    public Structure() {
        _id = UUID.randomUUID().toString();
    }
}
