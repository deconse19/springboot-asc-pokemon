package org.learning.withkyle.quasar_springboot.service;

import java.util.HashMap;
import java.util.Optional;

import org.learning.withkyle.quasar_springboot.dto.LoginTrainerDTO;
import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterDTO;
import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterResponseDTO;
import org.learning.withkyle.quasar_springboot.dto.mapper.TrainerMapper;
import org.learning.withkyle.quasar_springboot.model.Trainer;
import org.learning.withkyle.quasar_springboot.repository.TrainerRepository;
import org.learning.withkyle.quasar_springboot.utils.JwtUtil;
import org.learning.withkyle.quasar_springboot.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {
    @Autowired
    private PasswordUtil passwordUtil;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    public TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository, PasswordUtil passwordUtil) {
        this.trainerRepository = trainerRepository;
        this.passwordUtil = passwordUtil;

    }

    public TrainerRegisterResponseDTO registerTrainer(TrainerRegisterDTO newTrainer){
        
        

        Trainer trainer = TrainerMapper.registerMapper(newTrainer);
        trainer = trainerRepository.save(trainer);
        newTrainer.setTrainerId(trainer.getId());

        TrainerRegisterResponseDTO response = TrainerMapper.registerResponseMapper(trainer);

        return response;
    }

  
    public Optional<HashMap<String, String>> login(LoginTrainerDTO loginTrainerDto) {
        Optional<String> user = trainerRepository.checkUserName(loginTrainerDto.userName);
        if (user.isEmpty() || (!passwordUtil.verify(loginTrainerDto.password,
                user.get()))) {
            return Optional.empty();
        }

        final String accessToken = jwtUtil.generateAccessToken(loginTrainerDto);
        final String refreshToken = jwtUtil.generateRefreshToken(loginTrainerDto);
        

        Optional<HashMap<String, String>> map = Optional.of(new HashMap<>());
        map.get().put("accessToken", accessToken);
        map.get().put("refreshToken", refreshToken);
        return map;
    }
}   
