package com.bhavesh.college_campushub.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String semester;
    private String department;

}
