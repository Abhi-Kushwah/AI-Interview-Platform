package com.aiinterview.service;

import com.aiinterview.model.User;
import com.aiinterview.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository repo;

    public User register(User user) {
        return repo.save(user);
    }
}