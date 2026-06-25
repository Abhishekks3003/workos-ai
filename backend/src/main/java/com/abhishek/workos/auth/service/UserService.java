package com.abhishek.workos.auth.service;
import com.abhishek.workos.auth.entity.User;
import java.util.List;
import com.abhishek.workos.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.abhishek.workos.auth.dto.RegisterRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Service // to notify spring this is service class
public class UserService {

        private final UserRepository userRepository;
        private final BCryptPasswordEncoder passwordEncoder;

        public UserService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {

            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;

            System.out.println(userRepository);
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


}
