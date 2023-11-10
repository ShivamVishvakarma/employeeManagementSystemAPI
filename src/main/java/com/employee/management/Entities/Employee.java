package com.employee.management.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String firstName;
    private String LastName;
    private String email;

   @Column(name = "department_id")
    private String DepartmentId;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
