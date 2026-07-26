package com.bhavesh.college_campushub.Controller;

import com.bhavesh.college_campushub.Services.DepartmentService;
import com.bhavesh.college_campushub.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class Departmentcontroller {

    @Autowired
    private DepartmentService departmentService;

    // Create
    @PostMapping
    public Department createDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    // Get All
    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    // Get By Id
    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable String id){
        return departmentService.getDepartmentById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable String id,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable String id){

        departmentService.deleteDepartment(id);

        return "Department Deleted Successfully";
    }

}