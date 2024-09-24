package org.learning.withkyle.quasar_springboot.dto;

import lombok.Data;

@Data
public class TrainerRegisterDTO {

    private Long trainerId;

    private String userName;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;
    
    private String password;

}
