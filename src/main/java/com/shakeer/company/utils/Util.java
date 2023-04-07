package com.shakeer.company.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {

    public static String passwordEncoder(String password){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        java.lang.String hashedPassword = passwordEncoder.encode(password);
        System.out.println(" The user password :::" + hashedPassword);
        return hashedPassword;
    }
}
