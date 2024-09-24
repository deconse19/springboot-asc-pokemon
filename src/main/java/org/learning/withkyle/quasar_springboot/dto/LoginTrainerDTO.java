package org.learning.withkyle.quasar_springboot.dto;

import lombok.Data;

@Data
public class LoginTrainerDTO {
    public String userName;
    public String password;
    
    public LoginTrainerDTO(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
