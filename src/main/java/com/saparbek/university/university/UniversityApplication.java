package com.saparbek.university.university;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@OpenAPIDefinition(info = @Info(
		title = "University Management System",
		version = "1.0",
		description = "REST API for University Management"
))
public class UniversityApplication {
	public static void main(String[] args) {
		SpringApplication.run(UniversityApplication.class, args);
	}
}