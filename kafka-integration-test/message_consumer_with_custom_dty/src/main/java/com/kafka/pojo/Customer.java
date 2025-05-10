package com.kafka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Customer {
    String id;
    String name;
    String emailId;
    String department;

    public Customer(String id, String name, String emailId, String department) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.department = department;
    }
}
