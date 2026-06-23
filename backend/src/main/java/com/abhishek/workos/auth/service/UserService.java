package com.abhishek.workos.auth.service;
import com.abhishek.workos.auth.entity.User;
import java.util.List;
import com.abhishek.workos.auth.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service // to notify spring this is service class
public class UserService {

        private final UserRepository userRepository;
        public UserService(UserRepository userRepository) {

            this.userRepository = userRepository;

            System.out.println("UserService Bean Created");
            System.out.println(userRepository);
        }
        public void getAllUsers() {

            List<User> users = userRepository.findAll();

            System.out.println(users);
        }

}
