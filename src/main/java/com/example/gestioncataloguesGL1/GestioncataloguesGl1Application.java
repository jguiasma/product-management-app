package com.example.gestioncataloguesGL1;
import com.example.gestioncataloguesGL1.Entities.Categorie;
import com.example.gestioncataloguesGL1.Entities.Produit;
import com.example.gestioncataloguesGL1.Repositories.CategorieRepository;

import com.example.gestioncataloguesGL1.Service.ProduitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestioncataloguesGl1Application {

    CommandLineRunner runner(ProduitService produitService, CategorieRepository categorieRepository) {
        return args -> {
            Categorie categorie = Categorie.builder()
                    .nom("Electronique")
                    .build();
            categorieRepository.save(categorie);

            Produit produit = Produit.builder()
                    .nom("PC Portable")
                    .prix(3000)
                    .quantite(5)
                    .categorie(categorie)
                    .build();

            produitService.saveProduit(produit);

            // Afficher tous les produits
            produitService.getAllProduits();

        };
    }
        public static void main(String[] args) {
		SpringApplication.run(GestioncataloguesGl1Application.class, args);
	}

}
