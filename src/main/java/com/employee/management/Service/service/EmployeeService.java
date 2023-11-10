package com.employee.management.Service.service;

import com.employee.management.Entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {
    public List<Employee> getAllEmployees();

    Employee getEmployeesById(Long id);

    Employee CreateEmployee(Employee employee);



    Employee UpdateEmployee(Long id, Employee employee);

    boolean deleteEmployee(Long id);
}
