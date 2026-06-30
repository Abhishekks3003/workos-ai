package com.dev.workos.auth.service;
import com.dev.workos.auth.entity.User;
import java.util.List;
import com.dev.workos.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.dev.workos.auth.dto.RegisterRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.dev.workos.auth.dto.LoginRequest;
import java.util.Optional;
import com.dev.workos.auth.jwt.JwtService;


@Service // to notify spring this is service class
public class UserService {

        private final UserRepository userRepository;//field
        private final BCryptPasswordEncoder passwordEncoder;
        private final JwtService jwtService;

        public UserService(
                UserRepository userRepository,
                BCryptPasswordEncoder passwordEncoder,
                JwtService jwtService
        ) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
            this.jwtService = jwtService;
        }

        public List<User> getAllUsers() {

            return userRepository.findAll();

        }

        public String register(RegisterRequest request) {
            if (userRepository.existsByEmail(request.getEmail())) {
                return "Email already exists";
            }

            User user = new User();

            user.setName(request.getName());
            user.setEmail(request.getEmail());
            user.setPassword(
                    passwordEncoder.encode(request.getPassword())
            );

            userRepository.save(user);
            return "User Registred";
        }

        public String login(LoginRequest request) {

            Optional<User> optionalUser =
                    userRepository.findByEmail(request.getEmail());
    
            if (optionalUser.isEmpty()) {
                return "Invalid Email or Password";
            }

            User user = optionalUser.get();

            if (!passwordEncoder.matches(
                    request.getPassword(),
                    user.getPassword())) {

                return "Invalid Email or Password";
            }

        //return "Login Successful";
            String token = jwtService.generateToken(user);
            return token;
        }

}
