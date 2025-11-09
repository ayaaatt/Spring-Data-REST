package com.example.banque_api.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    // relation inverse (non propriétaire) : le propriétaire est Compte.client
    @OneToMany(mappedBy = "client")
    private List<Compte> comptes;
}
