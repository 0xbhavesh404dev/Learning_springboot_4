package com.bhavesh.college_campushub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "student")
public class Student {

    @Id
    private String id;

    private String name;

    private String email;

    private String phone;

    private String semester;

    @DBRef
    private Department department;
}