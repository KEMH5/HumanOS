package com.nerdtic.humanos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HumanOsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HumanOsApplication.class, args);
    }

}
