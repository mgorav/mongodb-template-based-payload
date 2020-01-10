package com.gonnect.template.data.templatebasedpayload.model.payload;

import com.gonnect.template.data.templatebasedpayload.model.enroll.Enrollment;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * A payload based on enrolled {@link Enrollment} template {@link com.gonnect.template.data.templatebasedpayload.model.enroll.TemplateDefinition}
 */
@Document
@Data
@ToString
public class Payload {
    @Id
    private String _id;
    // Point to the enrollment
    private String enrollmentId;
    private Map<String,String> row;

    public Payload() {

        _id = UUID.randomUUID().toString();
        row = new HashMap<>();
    }

    public void add(String columnName,String columnValue) {

        row.put(columnName,columnValue);
    }
}
