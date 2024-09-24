package org.learning.withkyle.quasar_springboot.service;

import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterDTO;
import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterResponseDTO;
import org.learning.withkyle.quasar_springboot.dto.mapper.TrainerMapper;
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

    public TrainerRegisterResponseDTO registerTrainer(TrainerRegisterDTO newTrainer){
        Trainer trainer = TrainerMapper.registerMapper(newTrainer);
        trainer = trainerRepository.save(trainer);
        newTrainer.setTrainerId(trainer.getId());

        TrainerRegisterResponseDTO response = TrainerMapper.registerResponseMapper(trainer);

        return response;
    }

}   
