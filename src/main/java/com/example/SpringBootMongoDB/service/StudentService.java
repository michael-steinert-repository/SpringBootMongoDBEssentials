package com.example.SpringBootMongoDB.service;

import com.example.SpringBootMongoDB.Repository.StudentRepository;
import com.example.SpringBootMongoDB.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
