package com.example.gestioncataloguesGL1.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categorie {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    @JsonIgnore
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    List<Produit> produits;
}
