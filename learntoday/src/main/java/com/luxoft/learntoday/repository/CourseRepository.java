package com.luxoft.learntoday.repository;

import com.luxoft.learntoday.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
