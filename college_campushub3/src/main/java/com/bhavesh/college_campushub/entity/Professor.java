package com.bhavesh.college_campushub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "professor")
public class Professor {

    @Id
    private String id;

    private String name;

    private String email;

    private String phone;

    private String designation;

    @DBRef
    private Department department;
}