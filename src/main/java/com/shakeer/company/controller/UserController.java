package com.shakeer.company.controller;


import com.shakeer.company.entity.User;
import com.shakeer.company.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;


    /* Password must not be exposed ......*/
 /*   @GetMapping("/user")
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

     */

    @PostMapping("user")
    public User login(@RequestParam("user") String username, @RequestParam("password") String pwd) {

        String token = getJWTToken(username);
        User user = new User();
        user.setUsername(username);
        user.setToken(token);
        return user;

    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }


}
