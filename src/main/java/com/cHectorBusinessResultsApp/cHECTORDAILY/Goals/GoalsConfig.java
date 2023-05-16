package com.cHectorBusinessResultsApp.cHECTORDAILY.Goals;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class GoalsConfig {
    @Bean
    CommandLineRunner commandLineRunner (GoalsRepository repository){
        return args ->{


        };
    }
}
