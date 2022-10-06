package com.luxoft.learntoday.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;
    @Column(name = "studentId")
    private int studentId;
//    @ManyToMany(targetEntity = Course.class,cascade = CascadeType.ALL)
//    @JoinColumn(name="students_Id",referencedColumnName = "enrollmentId")
//    private List<Course> courses;


//    @Column(name = "courseId")
//    private int courseId;
}
