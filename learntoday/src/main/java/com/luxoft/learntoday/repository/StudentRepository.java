package com.luxoft.learntoday.repository;

import com.luxoft.learntoday.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Long> {

}
