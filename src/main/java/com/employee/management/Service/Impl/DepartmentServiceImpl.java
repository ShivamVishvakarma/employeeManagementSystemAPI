package com.employee.management.Service.Impl;

import com.employee.management.Entities.Department;
import com.employee.management.Repository.DepartmentRepo;
import com.employee.management.Service.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepository;
    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentbyId(String id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public Department createdepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(String id, Department department) {
        if (departmentRepository.existsById(id)) {
            department.setDepartmentId(id);
            return departmentRepository.save(department);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteDepartment(String id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
