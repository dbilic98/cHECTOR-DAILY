package com.cHectorBusinessResultsApp.cHECTORDAILY.services;

import com.cHectorBusinessResultsApp.cHECTORDAILY.exception.UserNotFoundException;
import com.cHectorBusinessResultsApp.cHECTORDAILY.model.User;
import com.cHectorBusinessResultsApp.cHECTORDAILY.repositories.UserRepository;
import com.cHectorBusinessResultsApp.cHECTORDAILY.request.RequestUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    public final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user==null){
            throw new UserNotFoundException("User not found");
        }

        return new User(user.getUsername(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getPhone(),user.getPassword(),user.getVerified());
    }
    public User findUserById(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            throw new UserNotFoundException("User ID is not found");
        }
        return optionalUser.get();
    }
    public User updateUser(UUID id, RequestUserDto updatedUserDto) {
        User user = findUserById(id);

        user.setUsername(updatedUserDto.getUsername());
        user.setEmail(updatedUserDto.getEmail());
        user.setPhone(updatedUserDto.getPhone());
        return userRepository.save(user);
    }
}