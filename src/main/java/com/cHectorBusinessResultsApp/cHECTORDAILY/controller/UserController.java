package com.cHectorBusinessResultsApp.cHECTORDAILY.controller;

import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.JwtAuthenticationRequest;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.model.User;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.repository.UserRepository;
import com.cHectorBusinessResultsApp.cHECTORDAILY.controller.response.ResponseUserDto;
import com.cHectorBusinessResultsApp.cHECTORDAILY.domain.service.CustomUserDetailsService;
import com.cHectorBusinessResultsApp.cHECTORDAILY.controller.request.RequestUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseUserDto findUserById(@PathVariable UUID id) {
        User user = userService.findUserById(id);
        ResponseUserDto response = new ResponseUserDto(
                user.getId(),user.getUsername(),user.getEmail(),user.getPhone()
        );
        return response;
    }
    @PostMapping("/login")
    public ResponseUserDto login(@RequestBody JwtAuthenticationRequest authenticationRequest) {
        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();
        User user = userRepository.findByUsername(username);
        ResponseUserDto response = new ResponseUserDto(user.getId(),user.getUsername(),user.getEmail(),user.getPhone());

        return response;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseUserDto updateUser(@Valid @PathVariable("id") UUID id, @RequestBody RequestUserDto requestUserDto){
        User updatedUser = userService.updateUser(id, requestUserDto);
        ResponseUserDto response = new ResponseUserDto(updatedUser.getId(),
                updatedUser.getUsername(),
                updatedUser.getEmail(),
                updatedUser.getPhone());
        return response;
    }
}
