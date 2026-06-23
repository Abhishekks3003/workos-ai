package com.abhishek.workos.auth.repository;

import com.abhishek.workos.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

}