package com.gonnect.template.data.templatebasedpayload.document.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.List;
import java.util.UUID;

@Data
public class TemplateDefinition {

    @Id
    @Indexed(unique = true)
    private String _id;
    @Indexed
    private String templateName;
    private UserDefinition userDefinition;
    private List<Structure> structure;

    public TemplateDefinition() {
        _id = UUID.randomUUID().toString();
    }
}
