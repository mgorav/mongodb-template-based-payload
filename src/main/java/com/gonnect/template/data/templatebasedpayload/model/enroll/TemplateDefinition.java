package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Data
public class TemplateDefinition {

    @Id
    private String _id;
    private String templateName;
    private UserDefinition userDefinition;
    private List<Structure> structure;

    public TemplateDefinition() {
        _id = UUID.randomUUID().toString();
    }
}
