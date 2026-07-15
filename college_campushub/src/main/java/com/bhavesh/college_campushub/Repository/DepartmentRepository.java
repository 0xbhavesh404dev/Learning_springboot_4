package com.bhavesh.college_campushub.Repository;

import com.bhavesh.college_campushub.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {


}
