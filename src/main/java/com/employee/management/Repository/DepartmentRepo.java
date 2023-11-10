package com.employee.management.Repository;

import com.employee.management.Entities.Department;
import com.employee.management.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, String> {

}
