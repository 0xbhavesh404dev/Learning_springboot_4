package com.bhavesh.college_campushub.Services;

import com.bhavesh.college_campushub.Repository.DepartmentRepository;
import com.bhavesh.college_campushub.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get All
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get By Id
    public Optional<Department> getDepartmentById(String id) {
        return departmentRepository.findById(id);
    }

    // Update
    public Department updateDepartment(String id, Department updatedDepartment) {

        Optional<Department> optionalDepartment = departmentRepository.findById(id);

        if(optionalDepartment.isPresent()){

            Department department = optionalDepartment.get();

            department.setDepartmentName(updatedDepartment.getDepartmentName());
            department.setDepartmentCode(updatedDepartment.getDepartmentCode());

            return departmentRepository.save(department);
        }

        return null;
    }

    // Delete
    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }

}