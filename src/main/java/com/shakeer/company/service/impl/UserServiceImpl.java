package com.shakeer.company.service.impl;

import com.shakeer.company.entity.Role;
import com.shakeer.company.entity.User;
import com.shakeer.company.repository.UserRepository;
import com.shakeer.company.service.UserService;
import com.shakeer.company.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    public static final Long STANDARD_USER = 1l;
    public static final Long ADMIN_USER = 2l;
    @Autowired
    private UserRepository userRepository;



    @Override
    public User saveUser(User user) {
        Role role = new Role();
        role.setId(STANDARD_USER);
        List list = new ArrayList();
        list.add(role);
        user.setRoles(list);
        String hashedPassword = Util.passwordEncoder(user.getPassword());
        System.out.println(" The user password :::" + hashedPassword);
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
        //return userRepository.findAllByOrderByUserNameAsc();
        //return userRepository.findAllByOrderByUserIdAsc();


    }

    @Override
    public User getUserById(Long userId) {
      //  return userRepository.findById(userId).get();   ----  get() throws error if not value present , use isPresent()
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public void deleteUserById(Long userId) {
         userRepository.deleteById(userId);
    }

    @Override
    public User updateUser(Long userId,User user) {
        User userDB = userRepository.findById(userId).orElse(null);

        if(  Objects.isNull(userDB)) return null;

        if(Objects.nonNull(user.getFirstName()) && !"".equals(user.getFirstName())){
            userDB.setFirstName(user.getFirstName());
        }
        if(Objects.nonNull(user.getLastName()) && !"".equals(user.getLastName())){
            userDB.setLastName(user.getLastName());
        }
     /*   if(Objects.nonNull(user.getEmail()) && !"".equals(user.getEmail())){
            userDB.setEmail(user.getEmail());
        }   */
        return userRepository.save(userDB);

    }
        /* for testing java streams*/
        public List<User> getAllUsersBySalary(){
          List<User> userList = getAllUsers();
            List<User> sortedUserList = null;
            if(Objects.nonNull(userList)) {
           //     sortedUserList = userList.stream().sorted(Comparator.comparingDouble(User::getSalary)).collect(Collectors.toList());
            }
        return sortedUserList;
        }
}
