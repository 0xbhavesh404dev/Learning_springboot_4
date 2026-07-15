package com.bhavesh.college_campushub.entity;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class course{
    private String id;
    private String courseName;
    private String courseCode;
    private int credits;
    private String professor;
    private Department department;
}

//
//Department
//      │
//      ├──────── Professor
//      │
//      ├──────── Student
//      │
//      └──────── Course