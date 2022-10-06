package com.luxoft.learntoday.service;

import com.luxoft.learntoday.entity.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer saveTrainer(Trainer trainer);
    Trainer updateTrainer(Trainer trainer, long id);
    void deleteTrainer(long id);

}
