package com.example.oneToOne.repository;

import com.example.oneToOne.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
