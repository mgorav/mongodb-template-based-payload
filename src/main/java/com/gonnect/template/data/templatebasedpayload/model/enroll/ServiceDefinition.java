package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class ServiceDefinition {
    @Id
    private String _id;
    private UserDefinition userDefinition;
    private TemplateDefinition templateDefinition;

    public ServiceDefinition() {
        _id = UUID.randomUUID().toString();
    }
}
