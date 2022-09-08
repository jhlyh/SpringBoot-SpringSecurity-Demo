package com.jhlyh.spring_bootdemo.web;

import com.jhlyh.spring_bootdemo.entity.RegistrationForm;
import com.jhlyh.spring_bootdemo.entity.User;
import com.jhlyh.spring_bootdemo.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author jhlyh
 */
@RestController
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.userRepository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public String processRegistration(@RequestBody RegistrationForm registrationForm) {
        userRepository.save(registrationForm.toUser(passwordEncoder));
        return "test";
    }
}
