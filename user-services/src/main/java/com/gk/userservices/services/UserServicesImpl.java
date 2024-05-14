package com.gk.userservices.services;

import com.gk.userservices.entity.User;
import com.gk.userservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserid(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not found with the given id : "+userId));
    }
}
