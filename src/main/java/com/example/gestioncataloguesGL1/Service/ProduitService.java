package com.example.gestioncataloguesGL1.Service;

import com.example.gestioncataloguesGL1.Entities.Produit;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProduitService {

    Produit saveProduit(Produit produit); // créer ou mettre à jour un produit
    void updateProduit(Produit produit);
    Produit  getProduit(Long id);
    List<Produit> getProductsByMc(String nom);


    List<Produit> getAllProduits(); // récupérer tous les produits

    void deleteProduit(Long id); // supprimer un produit
    String saveImage(MultipartFile file) throws IOException;
    byte[] getImage(Long id) throws IOException;
    List<Produit> findByCategorieId(Long idCat);

}
