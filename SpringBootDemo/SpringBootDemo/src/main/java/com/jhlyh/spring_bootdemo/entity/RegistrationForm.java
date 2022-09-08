package com.jhlyh.spring_bootdemo.entity;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author jhlyh
 */
@Data
public class RegistrationForm {
    private final String username;
    private final String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User(username,passwordEncoder.encode(password));
    }
}
