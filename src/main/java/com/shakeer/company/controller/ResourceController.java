package com.shakeer.company.controller;

import com.shakeer.company.entity.City;
import com.shakeer.company.entity.User;
import com.shakeer.company.service.GenericService;
import com.shakeer.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private GenericService genericService;
    @Autowired
    private UserService userService;

    @GetMapping
    @RequestMapping(value ="/cities")
    @PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
    public List<City> getAllCities(){

        System.out.println(" ResourceController11111111  ResourceController");
        return genericService.findAllCities();
    }

    @RequestMapping(value ="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN_USER')")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }
}
