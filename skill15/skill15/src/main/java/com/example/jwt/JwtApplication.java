package com.example.jwt;

import com.example.jwt.model.User;
import com.example.jwt.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                userRepository.save(new User("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN"));
            }
            if (userRepository.findByUsername("employee").isEmpty()) {
                userRepository.save(new User("employee", passwordEncoder.encode("emp123"), "ROLE_EMPLOYEE"));
            }
        };
    }
}
