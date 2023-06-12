package com.cHectorBusinessResultsApp.cHECTORDAILY.controller;

import com.cHectorBusinessResultsApp.cHECTORDAILY.model.JwtAuthenticationRequest;
import com.cHectorBusinessResultsApp.cHECTORDAILY.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class LoginController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        return ResponseEntity.ok("Uspješno prijavljen");
    }
}
