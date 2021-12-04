package com.usa.retociclo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.usa.retociclo4.model"})
@SpringBootApplication
public class RetoCiclo4Application {

    public static void main(String[] args) {
        SpringApplication.run(RetoCiclo4Application.class, args);
    }

}
