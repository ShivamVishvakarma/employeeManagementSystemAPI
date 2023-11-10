package com.employee.management.Service.Impl;

import com.employee.management.Entities.Employee;
import com.employee.management.Repository.EmployeeRepo;
import com.employee.management.Service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceIMpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeesById(Long id) {
            return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee CreateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }



    @Override
    public Employee UpdateEmployee(Long id, Employee employee) {
       if(employeeRepository.existsById(id)){
           employee.setId(id);
           return employeeRepository.save(employee);
       }else{
           return null;
       }

    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
