package com.shakeer.company.service;

import com.shakeer.company.entity.User;

import java.util.List;

 public interface UserService {

/*testing*/
  User saveUser(User user);

/*for the test*/
  List<User> getAllUsers();

  User getUserById(Long userId);

  void deleteUserById(Long userId);

  User updateUser(Long userId,User user);

  List<User> getAllUsersBySalary();
}
