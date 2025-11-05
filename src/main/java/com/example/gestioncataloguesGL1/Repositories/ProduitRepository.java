package com.example.gestioncataloguesGL1.Repositories;

import com.example.gestioncataloguesGL1.Entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    //derieved query
    List<Produit> findByNomContains(String nom);

    @Query("select p from Produit p where p.categorie.id=:x")
    List<Produit> getProduitsByCategorie(@Param("x") Long idCat);
}

