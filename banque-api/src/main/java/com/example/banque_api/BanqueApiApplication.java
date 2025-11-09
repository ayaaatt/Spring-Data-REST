package com.example.banque_api;

import com.example.banque_api.Entity.*;
import com.example.banque_api.Repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class BanqueApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(BanqueApiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepo,
                            ClientRepository clientRepo,
                            RepositoryRestConfiguration restConfig) {
        return args -> {
            // exposer les IDs dans les réponses JSON
            restConfig.exposeIdsFor(Compte.class, Client.class);

            // seed clients
            Client c1 = clientRepo.save(new Client(null, "Amal", "amal@example.com", null));
            Client c2 = clientRepo.save(new Client(null, "Ali",  "ali@example.com",  null));

            // seed comptes associés
            compteRepo.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepo.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, c1));
            compteRepo.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, c2));
        };
    }
}
