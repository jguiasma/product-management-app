package com.example.gestioncataloguesGL1.Service.Impl;

import com.example.gestioncataloguesGL1.Entities.Produit;
import com.example.gestioncataloguesGL1.Repositories.ProduitRepository;
import com.example.gestioncataloguesGL1.Service.ProduitService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service // k truni yaamlk conteneur dinstance service bch njm nekhou instance testaamlou mbaad (je linjecte)

public class ProduitServiceImp implements ProduitService {

    private  ProduitRepository produitRepository;

    // Injection du repository via constructeur
    public ProduitServiceImp(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Produit saveProduit(Produit produit) {

        return produitRepository.save(produit);
    }
    public void updateProduit(Produit produit) {

        saveProduit(produit);
    }
    public Produit  getProduit(Long id) {

        return produitRepository.findById(id).orElse(null);
    }


    @Override
    public List<Produit> getProductsByMc(String nom) {
        return produitRepository.findByNomContains(nom);
    }



    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }



    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public List<Produit> findByCategorieId(Long idCat) {
        return produitRepository.getProduitsByCategorie(idCat);
    }

    public String saveImage(MultipartFile file) throws IOException {
        String name=file.getOriginalFilename(); // tjib lesm asli mta3 l’image lli l’utilisateur uploadé
        String newname=System.currentTimeMillis()+name; //→ hedhi t3ml esm jdid lel fichier bech ma yt3awadch (unique).
        Path p= Paths.get(System.getProperty("user.home")+"/imagesGL"); //→ hedhi t3ml chemin complet lel dossier + l’image.

        if(!Files.exists(p))
            Files.createDirectories(p);
        Path pfile=p.resolve(newname);
        Files.write(pfile,file. getBytes());
        return newname;
    }


    public byte[] getImage(Long id) throws IOException {
        Produit produit = getProduit( id) ;
        if (produit == null || produit.getPhoto() == null) {
            return null; // ou lancer une exception
        }
        Path imagePath = Paths.get(System.getProperty("user.home"), "/imagesGL", produit.getPhoto());
        return Files.readAllBytes(imagePath);
    }


}
