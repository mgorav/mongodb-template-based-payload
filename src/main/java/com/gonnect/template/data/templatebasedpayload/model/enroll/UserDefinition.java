package com.gonnect.template.data.templatebasedpayload.model.enroll;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class UserDefinition {
    @Id
    private String _id;
    private String userName;
    private Role role;
    private List<RoleOperation> operations;


    public UserDefinition() {
        _id = UUID.randomUUID().toString();
        operations = new ArrayList<>();
    }

    public void add(RoleOperation operation) {
        operations.add(operation);
    }
}
