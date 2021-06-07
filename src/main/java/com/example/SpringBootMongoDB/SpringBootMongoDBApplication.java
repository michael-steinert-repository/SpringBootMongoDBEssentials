package com.example.SpringBootMongoDB;

import com.example.SpringBootMongoDB.Repository.StudentRepository;
import com.example.SpringBootMongoDB.entity.Address;
import com.example.SpringBootMongoDB.entity.Gender;
import com.example.SpringBootMongoDB.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootMongoDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoDBApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, MongoTemplate mongoTemplate) {
        return args -> {
            String firstName = "Michael";
            Student student = new Student(
                    firstName,
                    "Steinert",
                    Gender.M,
                    new Address("Germany", "Froendenberg"),
                    true,
                    List.of("Maths", "English"),
                    BigDecimal.ONE,
                    LocalDateTime.now()
            );
            studentRepository.insert(student);

            /* Using Query and MongoTemplate */
            usingQueryAndMongoTemplate(mongoTemplate, firstName);

            /* Using MongoRepository */
            usingMongoRepository(studentRepository, firstName);
        };
    }

    private void usingMongoRepository(StudentRepository studentRepository, String firstName) {
        studentRepository.findStudentByFirstName(firstName).ifPresentOrElse(s -> {
            System.out.println(String.format("Student with First Name: %s exists", s.getFirstName()));
        }, () -> {
            throw new IllegalStateException(String.format("No Student found with First Name: %s", firstName));
        });
    }

    private void usingQueryAndMongoTemplate(MongoTemplate mongoTemplate, String firstName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("firstName").is(firstName));

        List<Student> studentList = mongoTemplate.find(query, Student.class);

        if(studentList.isEmpty()) {
            throw new IllegalStateException(String.format("No Students found with First Name: %s", firstName));
        } else {
            System.out.println(String.format("Students with First Name: %s exists", firstName));
        }
    }


}
