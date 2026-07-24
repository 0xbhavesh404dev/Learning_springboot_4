package com.bhavesh.college_campushub.Services;

import com.bhavesh.college_campushub.Repository.StudentRepository;
import com.bhavesh.college_campushub.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create
    public Student saveStudent(Student student){
        try {
            return studentRepository.save(student);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to save student: " + e.getMessage());
        }
    }

    // Get All
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    // Get By Id
    public Optional<Student> getStudentById(String id){
        return studentRepository.findById(id);
    }

    // Update
    public Student updateStudent(String id, Student updatedStudent){
        try {


            Optional<Student> optionalStudent = studentRepository.findById(id);

            if (optionalStudent.isPresent()) {

                Student student = optionalStudent.get();

                student.setName(updatedStudent.getName());
                student.setEmail(updatedStudent.getEmail());
                student.setPhone(updatedStudent.getPhone());
                student.setSemester(updatedStudent.getSemester());
                student.setDepartment(updatedStudent.getDepartment());

                return studentRepository.save(student);
            }

            return null;
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to update student: " + e.getMessage());
        }
    }

    // Delete
    public void deleteStudent(String id){
        studentRepository.deleteById(id);
    }
}