package com.cHectorBusinessResultsApp.cHECTORDAILY.repositories;

import com.cHectorBusinessResultsApp.cHECTORDAILY.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByUsername(String username);
}

