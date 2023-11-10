package com.employee.management.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "departments")
public class Department {

    @Id
    private String departmentId;

    private String departmentName;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}
