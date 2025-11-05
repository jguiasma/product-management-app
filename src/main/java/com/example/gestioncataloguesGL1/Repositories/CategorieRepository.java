package com.example.gestioncataloguesGL1.Repositories;

import com.example.gestioncataloguesGL1.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
