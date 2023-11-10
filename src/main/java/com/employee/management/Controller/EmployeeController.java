package com.employee.management.Controller;

import com.employee.management.Entities.Employee;
import com.employee.management.Service.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long Id){
        Employee employee = employeeService.getEmployeesById(Id);
        if(employee != null){
            return ResponseEntity.ok(employee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Employee> CreateEmployee(@RequestBody Employee employee){
        Employee createEmployee = employeeService.CreateEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEmployee);
    }

    @PostMapping("/id")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id , @RequestBody Employee employee)
    {
        Employee UpdateEmployee = employeeService.UpdateEmployee(id, employee);
        if(UpdateEmployee != null){
            return ResponseEntity.ok(UpdateEmployee);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
