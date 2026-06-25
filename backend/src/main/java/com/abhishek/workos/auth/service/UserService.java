package com.abhishek.workos.auth.service;
import com.abhishek.workos.auth.entity.User;
import java.util.List;
import com.abhishek.workos.auth.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.abhishek.workos.auth.dto.RegisterRequest;



@Service // to notify spring this is service class
public class UserService {

        private final UserRepository userRepository;
        public UserService(UserRepository userRepository) {

            this.userRepository = userRepository;

            System.out.println("UserService Bean Created");
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
            user.setPassword(request.getPassword());

            userRepository.save(user);
            return "User Registred";
        }


}
