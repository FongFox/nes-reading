package com.nesreading;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@SpringBootApplication(exclude = org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class)
public class NesReadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(NesReadingApplication.class, args);
	}

}
