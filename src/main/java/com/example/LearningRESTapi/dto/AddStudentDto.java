package com.example.LearningRESTapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddStudentDto {
    private String name;
    private String email;
}
