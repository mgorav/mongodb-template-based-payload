package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class ServiceDefinition {
    @Id
    @Indexed
    private String _id;
    private List<TemplateDefinition> templateDefinitions;

    public ServiceDefinition() {
        _id = UUID.randomUUID().toString();
        templateDefinitions = new ArrayList<>();
    }
}
