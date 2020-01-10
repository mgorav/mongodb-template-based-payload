package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class ValidationModule {
    private String _id;
    @Indexed
    private String name;
    private Map<String,String> args;

    public ValidationModule() {
        _id = UUID.randomUUID().toString();
        args = new HashMap<>();
    }

    public void addArg(String name,String value) {
        args.put(name,value);
    }
}
