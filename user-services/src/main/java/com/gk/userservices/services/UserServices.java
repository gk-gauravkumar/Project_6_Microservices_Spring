package com.gk.userservices.services;

import com.gk.userservices.entity.User;

import java.util.List;

public interface UserServices {

    User saveUser(User user);

    List<User> getAllUsers ();

    User getUserById(String userId);

    void delete(String userId);

}
