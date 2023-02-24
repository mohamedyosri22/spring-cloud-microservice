package com.spring.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableHystrix
public class PlayerStatisticApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlayerStatisticApplication.class, args);
    }

}
