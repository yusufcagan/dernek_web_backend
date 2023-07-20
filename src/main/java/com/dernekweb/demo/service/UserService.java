package com.dernekweb.demo.service;


import org.springframework.stereotype.Service;

import com.dernekweb.demo.entities.User;
import com.dernekweb.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        // Şifreyi kodlama
        // String encodedPassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(encodedPassword);
        // Kullanıcıyı kaydet
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}

