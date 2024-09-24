package org.learning.withkyle.quasar_springboot.dto.mapper;

import java.time.LocalDateTime;

import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterDTO;
import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterResponseDTO;
import org.learning.withkyle.quasar_springboot.model.Trainer;
import org.learning.withkyle.quasar_springboot.model.TrainerProfile;
import org.springframework.cglib.core.Local;

public class TrainerMapper {

    public static Trainer registerMapper(TrainerRegisterDTO trainerRegisterDTO){
        TrainerProfile trainerProfile = new TrainerProfile();
        trainerProfile.setFirstName(trainerRegisterDTO.getFirstName());
        trainerProfile.setMiddleName(trainerRegisterDTO.getMiddleName());
        trainerProfile.setLastName(trainerRegisterDTO.getLastName());
        trainerProfile.setEmail(trainerRegisterDTO.getEmail());
        
        Trainer trainer = new Trainer();
        trainer.setTrainerProfile(trainerProfile);
        trainer.setUserName(trainerRegisterDTO.getUserName());
        trainer.setPassword(trainerRegisterDTO.getPassword());
        trainer.setCreatedAt(LocalDateTime.now());
        trainer.setUpdatedAt(LocalDateTime.now());

        trainerProfile.setTrainer(trainer);

        return trainer;
    }

    public static TrainerRegisterResponseDTO registerResponseMapper(Trainer trainer){
        TrainerRegisterResponseDTO trainerRegisterResponseDTO = new TrainerRegisterResponseDTO();
        trainerRegisterResponseDTO.setUserName(trainer.getUserName());

        return trainerRegisterResponseDTO;
    }
}
