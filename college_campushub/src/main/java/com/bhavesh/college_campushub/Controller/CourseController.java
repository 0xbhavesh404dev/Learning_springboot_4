package com.bhavesh.college_campushub.Controller;

import com.bhavesh.college_campushub.Services.CourseService;
import com.bhavesh.college_campushub.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // Create
    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.saveCourse(course);
    }

    // Get All
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    // Get By Id
    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable String id){
        return courseService.getCourseById(id);
    }

    // Update
    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable String id,
                               @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable String id){

        courseService.deleteCourse(id);

        return "Course Deleted Successfully";
    }
}