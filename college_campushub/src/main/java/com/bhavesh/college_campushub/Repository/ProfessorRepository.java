package com.bhavesh.college_campushub.Repository;

import com.bhavesh.college_campushub.entity.Professor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorRepository extends MongoRepository<Professor, String> {

}