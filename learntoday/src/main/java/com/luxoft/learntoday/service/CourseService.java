package com.luxoft.learntoday.service;

import com.luxoft.learntoday.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CourseService {
    Course saveCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(long id);
    Course updateCourse(Course course, long id);
    void deleteCourse(long id);
}
