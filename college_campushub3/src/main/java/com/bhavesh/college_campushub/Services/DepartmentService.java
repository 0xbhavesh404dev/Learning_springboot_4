package com.bhavesh.college_campushub.Services;

import com.bhavesh.college_campushub.Repository.DepartmentRepository;
import com.bhavesh.college_campushub.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create
    @Transactional
    public Department saveDepartment(Department department) {
        try {
            return departmentRepository.save(department);
        }
        catch (Exception e) {
            throw new RuntimeException("Department could not be saved");
        }
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
    @Transactional
    public Department updateDepartment(String id, Department updatedDepartment) {
        try {

            Optional<Department> optionalDepartment = departmentRepository.findById(id);

            if (optionalDepartment.isPresent()) {

                Department department = optionalDepartment.get();

                department.setDepartmentName(updatedDepartment.getDepartmentName());
                department.setDepartmentCode(updatedDepartment.getDepartmentCode());

                return departmentRepository.save(department);
            }

            return null;
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to update department: " + e.getMessage());
        }
    }

    // Delete
    public void deleteDepartment(String id) {
        departmentRepository.deleteById(id);
    }

}