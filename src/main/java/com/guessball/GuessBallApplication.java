package com.guessball;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.guessball.mapper")
public class GuessBallApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuessBallApplication.class, args);
    }
}
