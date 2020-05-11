package com.genpact.demoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = { ErrorMvcAutoConfiguration.class })
public class SpringBootExample {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootExample.class, args);
	}
}
