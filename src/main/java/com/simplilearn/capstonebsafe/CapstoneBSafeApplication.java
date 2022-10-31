package com.simplilearn.capstonebsafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CapstoneBSafeApplication {
	public static void main(String[] args) {
		SpringApplication.run(CapstoneBSafeApplication.class, args);
	}

}