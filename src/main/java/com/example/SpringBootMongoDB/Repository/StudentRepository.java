package com.example.SpringBootMongoDB.Repository;

import com.example.SpringBootMongoDB.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByFirstName(String firstName);
}
