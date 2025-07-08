package com.thc.sprbasic2025summer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Sprbasic2025summerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sprbasic2025summerApplication.class, args);
    }

}
