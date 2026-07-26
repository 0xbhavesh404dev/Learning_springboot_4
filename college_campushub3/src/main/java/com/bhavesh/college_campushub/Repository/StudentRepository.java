package com.bhavesh.college_campushub.Repository;

import com.bhavesh.college_campushub.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}