package com.gonnect.template.data.templatebasedpayload.model.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gonnect.template.data.templatebasedpayload.model.enroll.Enrollment;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * A payload based on enrolled {@link Enrollment} template {@link com.gonnect.template.data.templatebasedpayload.model.enroll.TemplateDefinition}
 */
@Document(collection = "payload")
@Data
@ToString
public class Payload {
    @Id
    @Indexed
    private String _id;
    private String name;
    // Point to the enrollment
    @DBRef
    private Enrollment enrollment;
    @Indexed
    private List<Map<String, String>> rows;

    @JsonIgnore
    @Transient
    private int currentRow = -1;

    public Payload() {

        _id = UUID.randomUUID().toString();
        rows = new ArrayList<>();
        addNewRow();
    }


    public void add(String columnName, String columnValue) {

        rows.get(currentRow).put(columnName, columnValue);
    }

    //    public void addNewRow(String columnName, String columnValue) {
//        currentRow++;
//        rows.add(currentRow, new HashMap<>());
//        add(columnName, columnValue);
//    }
    public void addNewRow() {
        currentRow++;
        rows.add(currentRow, new HashMap<>());
    }
}
