package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Service {

    @Id
    private String _id;
    private String name;
    private ServiceDefinition serviceDefinition;
    private UserDefinition userDefinition;

    public Service() {
        _id = UUID.randomUUID().toString();
    }
}
