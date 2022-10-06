package com.luxoft.learntoday.service.impl;

import com.luxoft.learntoday.entity.Course;
import com.luxoft.learntoday.exception.ResourceNotFoundException;
import com.luxoft.learntoday.repository.CourseRepository;
import com.luxoft.learntoday.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        super();
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(long id) {
		Optional<Course> course = courseRepository.findById(id);
		if(course.isPresent()) {
			return course.get();
		}else {
			throw new ResourceNotFoundException("Course", "Id", id);
		}

    }

    @Override
    public Course updateCourse(Course course, long id) {

        // we need to check whether employee with given id is exist in DB or not
        Course existingCourse = courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course", "Id", id));

        existingCourse.setFees(course.getFees());
        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setTrainer(course.getTrainer());
        existingCourse.setStartDate(course.getStartDate());
        // save existing employee to DB
        courseRepository.save(existingCourse);
        return existingCourse;
    }

    @Override
    public void deleteCourse(long id) {

        courseRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Course", "Id", id));
        courseRepository.deleteById(id);
    }
}
