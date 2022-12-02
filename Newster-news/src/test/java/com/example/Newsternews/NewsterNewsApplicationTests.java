package com.example.Newsternews;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@EnableJpaRepositories("com.example")
class NewsterNewsApplicationTests {

	@Test
	void contextLoads() {
	}

}
