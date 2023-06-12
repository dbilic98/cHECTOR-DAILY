package com.cHectorBusinessResultsApp.cHECTORDAILY.services;

import com.cHectorBusinessResultsApp.cHECTORDAILY.model.CustomUserDetails;
import com.cHectorBusinessResultsApp.cHECTORDAILY.model.Korisnik;
import com.cHectorBusinessResultsApp.cHECTORDAILY.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Korisnik korisnik = userRepository.findByUsername(username);
        if(korisnik==null){
            throw new UsernameNotFoundException("Korisnik nije pronađen");
        }

        return new CustomUserDetails(korisnik);
    }
}
