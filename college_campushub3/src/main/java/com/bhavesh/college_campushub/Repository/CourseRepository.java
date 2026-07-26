package com.bhavesh.college_campushub.Repository;

import com.bhavesh.college_campushub.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {

}