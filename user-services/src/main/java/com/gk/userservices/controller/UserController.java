package com.gk.userservices.controller;

import com.gk.userservices.entity.User;
import com.gk.userservices.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServices userServices;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User user1 = userServices.saveUser(user);
        log.info("User Details Saved Successfully");
        return ResponseEntity.ok(user1);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers (){
        List<User> allUsersList = userServices.getAllUsers();
        log.info("All Users Details Fetched Successfully");
        return ResponseEntity.ok(allUsersList);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> delete(@PathVariable String userId){
        User user1 = userServices.getUserById(userId);
        log.info("User Details Fetched Successfully");
        userServices.delete(userId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user1 = userServices.getUserById(userId);
        log.info("User Details Fetched Successfully");
        return ResponseEntity.ok(user1);
    }

}
