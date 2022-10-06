package com.luxoft.learntoday.controller;


import com.luxoft.learntoday.entity.Trainer;

import com.luxoft.learntoday.service.TrainerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/learntoday/trainer")
public class TrainerController {
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        super();
        this.trainerService = trainerService;
    }

    @PostMapping()
    public ResponseEntity<Trainer> saveTrainer(@RequestBody Trainer trainer){
        return new ResponseEntity<Trainer>(trainerService.saveTrainer(trainer), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable("id") long id,@RequestBody Trainer trainer){
        return new ResponseEntity<Trainer>(trainerService.updateTrainer(trainer, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable("id") long id){

        trainerService.deleteTrainer(id);

        return new ResponseEntity<String>("Trainer deleted successfully!.", HttpStatus.OK);
    }
}
