package com.employee.management.Controller;

import com.employee.management.Entities.Department;
import com.employee.management.Service.service.DepartmentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentId(@PathVariable String id){
        Department department = departmentService.getDepartmentbyId(id);
        if(department!= null){
            return ResponseEntity.ok(department);

        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department  createdepartment = departmentService.createdepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdepartment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable String id, @RequestBody Department department) {
        Department updatedDepartment = departmentService.updateDepartment(id, department);
        if (updatedDepartment != null) {
            return ResponseEntity.ok(updatedDepartment);
        } else {
            return ResponseEntity.notFound().build();
        }


        }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable String id) {
        boolean deleted = departmentService.deleteDepartment(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
