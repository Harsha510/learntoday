package com.luxoft.learntoday.service.impl;

import com.luxoft.learntoday.entity.Student;
import com.luxoft.learntoday.exception.ResourceNotFoundException;
import com.luxoft.learntoday.pojo.CourseRequest;
import com.luxoft.learntoday.repository.StudentRepository;
import com.luxoft.learntoday.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
   public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        System.out.println("student__________________"+student);
//        Course course= studentRepository.findByCourseId();
        if(student.isPresent()) {
            return student.get();
        }else {
            throw new ResourceNotFoundException("Student", "Id", id);
        }

    }

    @Override
    public Student updateStudent(Student Student, long id) {

        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "Id", id));

        existingStudent.setStudentId(Student.getStudentId());
//        existingStudent.setCourseId(Student.getCourseId());
        studentRepository.save(existingStudent);
        return existingStudent;
    }

    @Override
    public void deleteStudent(long id) {

        studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
        studentRepository.deleteById(id);
    }
}
