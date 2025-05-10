package com.kafka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    String id;
    String name;
    String emailId;
    String department;
}
