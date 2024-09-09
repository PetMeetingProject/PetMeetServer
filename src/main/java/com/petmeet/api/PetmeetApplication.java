package com.petmeet.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PetmeetApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetmeetApplication.class, args);
    }

}
