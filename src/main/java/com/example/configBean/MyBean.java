package com.example.configBean;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner {

    public void run(String... args) {
        // Do something...
        System.out.println(args);
        System.out.println("be called just before SpringApplication.run(…\u200B) completes");
    }

}