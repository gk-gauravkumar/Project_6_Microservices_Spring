package com.gk.userservices.controller;

import com.gk.userservices.entity.User;
import com.gk.userservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User user1 = userServices.saveUser(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers (){
        List<User> allUsersList = userServices.getAllUsers();
        return ResponseEntity.ok(allUsersList);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user1 = userServices.getUserById(userId);
        return ResponseEntity.ok(user1);
    }

}
