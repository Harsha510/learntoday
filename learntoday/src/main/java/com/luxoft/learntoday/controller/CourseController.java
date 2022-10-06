package com.luxoft.learntoday.controller;

import com.luxoft.learntoday.entity.Course;
import com.luxoft.learntoday.pojo.CourseRequest;
import com.luxoft.learntoday.repository.CourseRepository;
import com.luxoft.learntoday.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/learntoday")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        super();
        this.courseService = courseService;
    }

//    @PostMapping()
//    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
//        return new ResponseEntity<Course>(courseService.saveCourse(course), HttpStatus.CREATED);
//    }

    @PostMapping()
    public Course saveCourse(@RequestBody CourseRequest courseRequest){
        return  courseRepository.save(courseRequest.getCourse());
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") long courseId){
        if(courseId!=0) {
            return new ResponseEntity<Course>(courseService.getCourseById(courseId), HttpStatus.OK);
        }else{
            return new ResponseEntity<Course>(courseService.getCourseById(courseId), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") long id,@RequestBody Course course){
        return new ResponseEntity<Course>(courseService.updateCourse(course, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") long id){

        courseService.deleteCourse(id);

        return new ResponseEntity<String>("Course deleted successfully!.", HttpStatus.OK);
    }
}
