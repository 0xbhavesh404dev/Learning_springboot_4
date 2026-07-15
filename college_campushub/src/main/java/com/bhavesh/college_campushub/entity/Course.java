package com.bhavesh.college_campushub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "course")
public class Course {

    @Id
    private String id;

    private String courseName;

    private String courseCode;

    private int credits;

    @DBRef
    private Professor professor;

    @DBRef
    private Department department;
}