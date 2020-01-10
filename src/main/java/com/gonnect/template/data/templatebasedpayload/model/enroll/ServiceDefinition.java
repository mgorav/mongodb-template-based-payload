package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ServiceDefinition {
    @Id
    private String _id;
    private UserDefinition userDefinition;
    private List<TemplateDefinition> templateDefinitions;

    public ServiceDefinition() {
        _id = UUID.randomUUID().toString();
        templateDefinitions = new ArrayList<>();
    }
}
