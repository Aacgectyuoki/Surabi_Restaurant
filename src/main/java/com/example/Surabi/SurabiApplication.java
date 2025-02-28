package com.example.Surabi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.Surabi")
public class SurabiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurabiApplication.class, args);
	}
}