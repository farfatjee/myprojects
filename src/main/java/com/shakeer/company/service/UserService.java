package com.shakeer.company.service;

import com.shakeer.company.entity.User;

import java.util.List;

 public interface UserService {


  User saveUser(User user);


  List<User> getAllUsers();

  User getUserById(Long userId);

  void deleteUserById(Long userId);

  User updateUser(Long userId,User user);

  List<User> getAllUsersBySalary();
}
