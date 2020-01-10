package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Map;
import java.util.UUID;

@Data
public class Structure {
    @Id
    private String _id;
    @Indexed
    private String columnName;
    private ValidationModule validationModule;
    private boolean isPk;
    private boolean isIndexed;

    public Structure() {
        _id = UUID.randomUUID().toString();
    }
}
