package com.cHectorBusinessResultsApp.cHECTORDAILY.repositories;

import com.cHectorBusinessResultsApp.cHECTORDAILY.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByUsername(String username);
}

