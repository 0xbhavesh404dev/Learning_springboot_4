package com.bhavesh.college_campushub.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Professor {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String designation;
    private Department department;
}
