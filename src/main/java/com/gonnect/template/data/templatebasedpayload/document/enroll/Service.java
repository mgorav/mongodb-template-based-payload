package com.gonnect.template.data.templatebasedpayload.document.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.UUID;

@Data
public class Service {

    @Id
    @Indexed
    private String _id;
    @Indexed
    private String name;
    private String version;
    private ServiceDefinition serviceDefinition;
    private UserDefinition userDefinition;

    public Service() {
        _id = UUID.randomUUID().toString();
    }
}
