package org.learning.withkyle.quasar_springboot.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class JwtClaim {
    public String userName;
}