package com.example.Newsternews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EntityScan("com.example")
@EnableJpaRepositories("com.example")
public class NewsterNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsterNewsApplication.class, args);
	}



}
