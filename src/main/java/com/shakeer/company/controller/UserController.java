package com.shakeer.company.controller;


import com.shakeer.company.entity.User;
import com.shakeer.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    /* Password must not be exposed */
    @GetMapping("/user")
    public List<User> getAllUsers(){

        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public User saveUser(@RequestBody User user ){
        return userService.saveUser(user);
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }
    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable("id")Long userId){
        userService.deleteUserById(userId);
        return " user successfully deleted";
    }

    @PutMapping("user/{id}")
    public User updateUser(@PathVariable("id") Long userId,@RequestBody User user){
        return userService.updateUser(userId,user);
    }

    @GetMapping("/user/salary")
    public List<User> getAllUserBySalary(){
        return userService.getAllUsersBySalary();
    }
}
