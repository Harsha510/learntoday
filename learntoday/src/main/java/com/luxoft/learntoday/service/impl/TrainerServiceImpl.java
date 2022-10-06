package com.luxoft.learntoday.service.impl;


import com.luxoft.learntoday.entity.Trainer;
import com.luxoft.learntoday.exception.ResourceNotFoundException;
import com.luxoft.learntoday.repository.TrainerRepository;
import com.luxoft.learntoday.service.TrainerService;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {
    private TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        super();
        this.trainerRepository = trainerRepository;
    }
    @Override
    public Trainer saveTrainer(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    @Override
    public Trainer updateTrainer(Trainer trainer, long id) {

        Trainer existingTrainer = trainerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "Id", id));

        existingTrainer.setPassword(trainer.getPassword());
        trainerRepository.save(existingTrainer);
        return existingTrainer;
    }
    @Override
    public void deleteTrainer(long id) {

        trainerRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student", "Id", id));
        trainerRepository.deleteById(id);
    }
}
