package com.luxoft.learntoday.repository;

import com.luxoft.learntoday.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<Trainer,Long> {
}
