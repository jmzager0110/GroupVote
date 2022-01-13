package com.liftoff.soloproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SoloProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoloProjectApplication.class, args);
	}

}
