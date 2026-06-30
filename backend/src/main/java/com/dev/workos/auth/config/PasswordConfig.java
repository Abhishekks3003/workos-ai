package com.dev.workos.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class PasswordConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //@bean mtlb iss method se
        // jo object return hoga use IOC container me daal do
        return new BCryptPasswordEncoder();
    }
}