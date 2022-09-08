package com.jhlyh.spring_bootdemo.repository;

import com.jhlyh.spring_bootdemo.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUsername(String username);
}
