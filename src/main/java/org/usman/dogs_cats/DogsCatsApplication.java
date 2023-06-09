package org.usman.dogs_cats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DogsCatsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DogsCatsApplication.class, args);
    }

}
