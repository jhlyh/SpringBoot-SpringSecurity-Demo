package com.jhlyh.spring_bootdemo.web;

import com.jhlyh.spring_bootdemo.entity.User;
import com.jhlyh.spring_bootdemo.repository.UserRepository;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author jhlyh
 */
@RestController
@RequestMapping("/principal")
public class GetPrincipalController {

    UserRepository userRepository;

    public GetPrincipalController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String Order(@AuthenticationPrincipal User user) {
        return user.toString();
    }
}
