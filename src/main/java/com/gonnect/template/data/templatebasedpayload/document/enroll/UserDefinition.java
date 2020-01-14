package com.gonnect.template.data.templatebasedpayload.document.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserDefinition {
    @Id
    @Indexed
    private String _id;
    @Indexed
    private String userName;
    @Indexed
    private Role role;
    @Indexed
    private List<RoleOperation> operations;


    public UserDefinition() {
        _id = UUID.randomUUID().toString();
        operations = new ArrayList<>();
    }

    public void add(RoleOperation operation) {
        operations.add(operation);
    }
}
