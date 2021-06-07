package com.example.SpringBootMongoDB.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
    private String county;
    private String city;
}
