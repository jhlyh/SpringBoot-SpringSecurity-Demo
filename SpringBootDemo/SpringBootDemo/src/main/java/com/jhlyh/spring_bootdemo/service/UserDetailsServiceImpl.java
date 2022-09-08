package com.jhlyh.spring_bootdemo.service;

import com.jhlyh.spring_bootdemo.entity.User;
import com.jhlyh.spring_bootdemo.repository.UserDetailsService;
import com.jhlyh.spring_bootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author jhlyh
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException(
                    "User " + username + "not found"
            );
        }
    }
}
