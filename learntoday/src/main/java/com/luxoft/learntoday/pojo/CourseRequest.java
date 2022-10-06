package com.luxoft.learntoday.pojo;

import com.luxoft.learntoday.entity.Course;
import com.luxoft.learntoday.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class CourseRequest {
    private Course course;
    private Student student;
}
