package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.entity.Department;
import com.example.entity.EmployeeEntity;
import com.example.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public Department createDepartment(Department department ){
        departmentRepository.save(department);
        return department;
    }

    public List<Department> fetchAllDepartment() {
        return departmentRepository.findAll();
    }
}
