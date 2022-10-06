package com.luxoft.learntoday.controller;



import com.luxoft.learntoday.entity.Student;
import com.luxoft.learntoday.repository.StudentRepository;
import com.luxoft.learntoday.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/learntoday/student")

public class StudentController {
    private StudentService studentService;
    @Autowired
    StudentRepository studentRepository;


    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

//    @PostMapping()
//    public Student saveStudent(@RequestBody CourseRequest courseRequest){
//        return  studentRepository.save(courseRequest.getStudent());
//    }



    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long enrollmentId){
        if(enrollmentId!=0) {
            return new ResponseEntity<Student>(studentService.getStudentById(enrollmentId), HttpStatus.OK);
        }else{
            return new ResponseEntity<Student>(studentService.getStudentById(enrollmentId), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") long id){

        studentService.deleteStudent(id);

        return new ResponseEntity<String>("Student deleted successfully!.", HttpStatus.OK);
    }
}
