package com.join.TinyProgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.join.TinyProgram.mapper","com.join.TinyProgram.controller","com.join.TinyProgram.service","com.join.TinyProgram.entity"})
public class TinyProgramApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyProgramApplication.class, args);
    }

}
