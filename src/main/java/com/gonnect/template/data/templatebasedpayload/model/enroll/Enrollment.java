package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "enrollment")
@Data
@ToString
public class Enrollment {

    @Id
    @Indexed
    private String _id;
    private Service service;

    public Enrollment() {

        _id = UUID.randomUUID().toString();

    }
}
