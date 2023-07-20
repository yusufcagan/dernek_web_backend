package com.dernekweb.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dernekweb.demo.entities.User;


public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
