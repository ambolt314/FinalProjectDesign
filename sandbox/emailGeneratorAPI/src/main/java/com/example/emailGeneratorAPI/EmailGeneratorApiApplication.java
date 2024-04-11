package com.example.emailGeneratorAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class EmailGeneratorApiApplication {

	public static void main(String[] args) {
		//SpringApplication.run(EmailGeneratorApiApplication.class, args);

		SpringApplicationBuilder builder = new SpringApplicationBuilder(EmailGeneratorApiApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

}
