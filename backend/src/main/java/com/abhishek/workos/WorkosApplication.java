package com.abhishek.workos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.abhishek.workos.auth.entity.User;


@SpringBootApplication
public class WorkosApplication {

	public static void main(String[] args) {
		User user = new User();
		user.SetName("ALM");
		System.out.println(user.GetName());
		SpringApplication.run(WorkosApplication.class, args);
	}

}
