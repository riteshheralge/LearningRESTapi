package com.example.LearningRESTapi.service.impl;


import com.example.LearningRESTapi.dto.AddStudentDto;
import com.example.LearningRESTapi.dto.StudentDto;
import com.example.LearningRESTapi.entity.Student;
import com.example.LearningRESTapi.repository.StudentRepository;
import com.example.LearningRESTapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students=studentRepository.findAll();
        return students.stream()
                    .map(student -> new StudentDto(
                            student.getId(),
                            student.getName(),
                            student.getEmail()
                    ))
                    .toList();
    }

    @Override
    public StudentDto getStudentsById(Long id) {
       Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
       return modelMapper.map(student,StudentDto.class);
         /*
        return new StudentDto(
                student.getId(),
                student.getName(),
                student.getEmail()
        );*/

    }

    @Override
    public StudentDto createStudent(AddStudentDto addStudentDto) {
        Student newStudent=modelMapper.map(addStudentDto,Student.class);
        Student student=studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exist by id"+id);
        }
        studentRepository.deleteById(id);
    }


}
