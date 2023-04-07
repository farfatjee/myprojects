package com.shakeer.company.controller;

import com.shakeer.company.entity.City;
import com.shakeer.company.entity.Role;
import com.shakeer.company.entity.User;
import com.shakeer.company.service.GenericService;
import com.shakeer.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private GenericService genericService;
    @Autowired
    private UserService userService;



    /* Standard user */
    @PostMapping(value="/users")
   public User saveUser(@RequestBody User user){

        return userService.saveUser(user);
    }
}
