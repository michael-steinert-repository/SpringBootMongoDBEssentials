package com.example.SpringBootMongoDB.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Student {
    @Id
    private String id;
    @Indexed(unique = true)
    private String firstName;
    private String lastName;
    private Gender gender;
    private Address address;
    private boolean isActiveStudent;
    private List<String> favouriteSubjects;
    private BigDecimal totalSpentInBook;
    private LocalDateTime createdAt;

    public Student(String firstName,
                   String lastName,
                   Gender gender,
                   Address address,
                   boolean isActiveStudent,
                   List<String> favouriteSubjects,
                   BigDecimal totalSpentInBook,
                   LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.isActiveStudent = isActiveStudent;
        this.favouriteSubjects = favouriteSubjects;
        this.totalSpentInBook = totalSpentInBook;
        this.createdAt = createdAt;
    }
}
