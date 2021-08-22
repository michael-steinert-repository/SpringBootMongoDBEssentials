package com.example.SpringBootMongoDB.service;

import com.example.SpringBootMongoDB.Repository.StudentRepository;
import com.example.SpringBootMongoDB.entity.Student;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findAllStudentsWithSorting(String field) {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    public Page<Student> findAllStudentsWithPagination(int offset, int pageSize) {
        return studentRepository.findAll(PageRequest.of(offset, pageSize));
    }

    public Page<Student> findAllStudentsWithSortingAndPagination(String field, int offset, int pageSize) {
        return studentRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.ASC, field));
    }
}
