package org.learning.withkyle.quasar_springboot.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

import org.learning.withkyle.quasar_springboot.dto.LoginTrainerDTO;
import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterDTO;
import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterResponseDTO;
import org.learning.withkyle.quasar_springboot.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class AuthController {
  @Autowired
    private final TrainerService trainerService;

    public AuthController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> regTrainer(@RequestBody TrainerRegisterDTO trainerRegisterDTO) {
        try {
            TrainerRegisterResponseDTO newTrainerResponse = trainerService.registerTrainer(trainerRegisterDTO);

            return ResponseEntity.ok(newTrainerResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Registration failed: " + e.getMessage());
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> loginTrainer(@RequestBody LoginTrainerDTO loginTrainerDto) {
        try {
            Optional<HashMap<String, String>> result = trainerService.login(loginTrainerDto);
            if (result.isEmpty()) {
                return new ResponseEntity<>(Collections.singletonMap("message", "Incorrect username and/or password"),
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(Collections.singletonMap("data", result), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(
                    Collections.singletonMap("message", "An unexpected error occurred"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
