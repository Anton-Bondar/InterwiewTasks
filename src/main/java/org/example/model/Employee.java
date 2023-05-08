package org.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private Long department;
}
