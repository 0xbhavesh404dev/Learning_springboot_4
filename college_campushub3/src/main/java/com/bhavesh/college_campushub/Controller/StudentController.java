package com.bhavesh.college_campushub.Controller;

import com.bhavesh.college_campushub.Services.StudentService;
import com.bhavesh.college_campushub.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create
    @PostMapping
    public Student createStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    // Get All
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    // Get By Id
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id,
                                 @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id){

        studentService.deleteStudent(id);

        return "Student Deleted Successfully";
    }
}