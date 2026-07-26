package com.bhavesh.college_campushub.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "department")
public class Department {
    @Id
    private String id;

    private String departmentName;

    private String departmentCode;
}