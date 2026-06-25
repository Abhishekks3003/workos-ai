package com.abhishek.workos;

import com.abhishek.workos.auth.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class WorkosApplication implements CommandLineRunner {

	private final UserService userService;

	public WorkosApplication(UserService userService) {
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkosApplication.class, args);
	}

	@Override
	public void run(String... args) {

		userService.getAllUsers();

	}
}