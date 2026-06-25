package com.abhishek.workos.auth.controller;
import com.abhishek.workos.auth.dto.RegisterRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.abhishek.workos.auth.entity.User;
import com.abhishek.workos.auth.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import java.util.List;
import com.abhishek.workos.auth.dto.LoginRequest;

@RestController
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/api/auth/users")
    public List<User> getUsers() {

        return userService.getAllUsers();

    }
    @PostMapping("/api/auth/register")
    public String register(
            @Valid @RequestBody RegisterRequest request) {

        return userService.register(request); //controller method run

    }
    @PostMapping("/api/auth/login")
    public String login(
            @Valid @RequestBody LoginRequest request) {

        return userService.login(request);
    }
}