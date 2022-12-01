package com.example.Newsternews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NewsterNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsterNewsApplication.class, args);
	}



}
