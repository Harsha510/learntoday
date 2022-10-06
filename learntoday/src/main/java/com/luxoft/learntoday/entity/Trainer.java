package com.luxoft.learntoday.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="trainer")
@Data
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    @Column(name="password")
    private String password;
}
