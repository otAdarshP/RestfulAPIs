package com.RestfulAPIs.RestfulAPIs.Repository;

import com.RestfulAPIs.RestfulAPIs.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // here we write all the queries for manipulating with the database
}
