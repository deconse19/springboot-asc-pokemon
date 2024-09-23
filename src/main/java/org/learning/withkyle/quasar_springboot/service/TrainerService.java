package org.learning.withkyle.quasar_springboot.service;

import org.learning.withkyle.quasar_springboot.model.Trainer;
import org.learning.withkyle.quasar_springboot.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    @Autowired
    public TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public Trainer registerTrainer(Trainer trainer){
        return trainerRepository.save(trainer);
    }

}   
