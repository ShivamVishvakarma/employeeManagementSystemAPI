package com.employee.management.Service.service;

import com.employee.management.Entities.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {


    List<Department> getAllDepartments();

    Department getDepartmentbyId(String id);

    Department createdepartment(Department department);

    Department updateDepartment(String id, Department department);

    boolean deleteDepartment(String id);
}
