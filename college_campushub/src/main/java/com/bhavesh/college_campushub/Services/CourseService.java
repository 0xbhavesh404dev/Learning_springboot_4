package com.bhavesh.college_campushub.Services;

import com.bhavesh.college_campushub.Repository.CourseRepository;
import com.bhavesh.college_campushub.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create
    @Transactional
    public Course saveCourse(Course course){
        try {
            return courseRepository.save(course);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to save course: " + e.getMessage());
        }
    }

    // Get All
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    // Get By Id
    public Optional<Course> getCourseById(String id){
        return courseRepository.findById(id);
    }

    // Update
    @Transactional
    public Course updateCourse(String id, Course updatedCourse){
        try {

            Optional<Course> optionalCourse = courseRepository.findById(id);

            if (optionalCourse.isPresent()) {

                Course course = optionalCourse.get();

                course.setCourseName(updatedCourse.getCourseName());
                course.setCourseCode(updatedCourse.getCourseCode());
                course.setCredits(updatedCourse.getCredits());
                course.setProfessor(updatedCourse.getProfessor());
                course.setDepartment(updatedCourse.getDepartment());

                return courseRepository.save(course);
            }

            return null;
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to update course: " + e.getMessage());
        }
    }

    // Delete
    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }
}