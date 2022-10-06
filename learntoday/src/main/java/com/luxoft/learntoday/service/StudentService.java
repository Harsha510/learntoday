package com.luxoft.learntoday.service;

import com.luxoft.learntoday.entity.Student;
import com.luxoft.learntoday.pojo.CourseRequest;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student updateStudent(Student student, long id);
    void deleteStudent(long id);
}
