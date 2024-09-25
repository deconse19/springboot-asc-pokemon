package org.learning.withkyle.quasar_springboot.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

import org.learning.withkyle.quasar_springboot.dto.LoginTrainerDTO;
import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterDTO;
import org.learning.withkyle.quasar_springboot.dto.TrainerRegisterResponseDTO;
import org.learning.withkyle.quasar_springboot.model.Trainer;
import org.learning.withkyle.quasar_springboot.model.TrainerProfile;
import org.learning.withkyle.quasar_springboot.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins = "http://localhost:9000")
public class TrainerController {
  
    @GetMapping("/home")
    public String home(){
        return "hello home";

    }
}
