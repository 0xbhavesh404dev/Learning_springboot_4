package com.bhavesh.college_campushub.Services;

import com.bhavesh.college_campushub.Repository.CourseRepository;
import com.bhavesh.college_campushub.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create
    public Course saveCourse(Course course){
        return courseRepository.save(course);
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
    public Course updateCourse(String id, Course updatedCourse){

        Optional<Course> optionalCourse = courseRepository.findById(id);

        if(optionalCourse.isPresent()){

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

    // Delete
    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }
}