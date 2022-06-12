package com.oleglmn.camundaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CamundaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CamundaServiceApplication.class, args);
    }

}
