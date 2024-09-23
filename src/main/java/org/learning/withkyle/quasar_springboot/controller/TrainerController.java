package org.learning.withkyle.quasar_springboot.controller;

import org.learning.withkyle.quasar_springboot.model.Trainer;
import org.learning.withkyle.quasar_springboot.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TrainerController {
    @Autowired
    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("")
    public ResponseEntity<?> regTrainer(@RequestBody Trainer trainer){
        try {
            Trainer newTrainer = trainerService.registerTrainer(trainer);
            
            return ResponseEntity.ok(newTrainer);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("Registration failed: " + e.getMessage());
        }
    }
}
