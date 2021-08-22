package com.example.SpringBootMongoDB.controller;

import com.example.SpringBootMongoDB.entity.Student;
import com.example.SpringBootMongoDB.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents() {
        return ResponseEntity.ok().body(studentService.findAllStudents());
    }

    @GetMapping("/{field}")
    public ResponseEntity<List<Student>> findAllStudentsWithSorting(@PathVariable String field) {
        return ResponseEntity.ok().body(studentService.findAllStudentsWithSorting(field));
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    public ResponseEntity<Page<Student>> findAllStudentsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        return ResponseEntity.ok().body(studentService.findAllStudentsWithPagination(offset, pageSize));
    }

    @GetMapping("/pagination-and-sorting/{field}/{offset}/{pageSize}")
    public ResponseEntity<Page<Student>> findAllStudentsWithSortingAndPagination(@PathVariable String field, @PathVariable int offset, @PathVariable int pageSize) {
        return ResponseEntity.ok().body(studentService.findAllStudentsWithSortingAndPagination(field, offset, pageSize));
    }
}
