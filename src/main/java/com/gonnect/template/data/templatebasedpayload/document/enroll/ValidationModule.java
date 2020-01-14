package com.gonnect.template.data.templatebasedpayload.document.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class ValidationModule {

    @Id
    @Indexed
    private String _id;
    @Indexed(unique = true)
    private String name;
    private Map<String, String> args;

    public ValidationModule() {
        _id = UUID.randomUUID().toString();
        args = new HashMap<>();
    }

    public void addArg(String name, String value) {
        args.put(name, value);
    }
}
