package com.luxoft.learntoday.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name ="course")
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long courseId;
    @Column(name="title")
    private String title;
    @Column(name="trainer")
    private String trainer;
    @Column(name="description")
    private String description;
    @Column(name="fees")
    private int fees;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = Shape.STRING)
    @Column(name="start_Date")
    private String startDate;
    @OneToMany(targetEntity = Student.class,cascade = CascadeType.ALL)
    @JoinColumn(name="courses_Id",referencedColumnName = "courseId")
    private List<Student> Students;
}
