package com.example.gestioncataloguesGL1.Controller;

import com.example.gestioncataloguesGL1.Entities.Produit;
import com.example.gestioncataloguesGL1.Service.ProduitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProduitController {
    private ProduitService produitService;
    @GetMapping("/all")
    public List<Produit> findAllProduits(){
        return produitService.getAllProduits();
    }
    @GetMapping("/{id}")
    public Produit rechercherProduitsId(@PathVariable Long id){
     return produitService.getProduit(id);
    }
    @GetMapping("/search")
    public List<Produit> getProductsByMC(@RequestParam String mc){
     return produitService.getProductsByMc(mc);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduit(@PathVariable Long id){
     produitService.deleteProduit(id);
    }

    @PostMapping(value = "/products/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addProduit(
            @RequestParam("produit") String produitJson,
            @RequestParam(value = "file", required = false) MultipartFile file
    ) throws IOException {

        // 🔹 Désérialiser le JSON en objet Produit
        Produit produit = new ObjectMapper().readValue(produitJson, Produit.class);

        // 🔹 Si un fichier est fourni, l’uploader et associer au produit
        if (file != null && !file.isEmpty()) {
            String photoName = produitService.saveImage(file);
            produit.setPhoto(photoName);
        }

        // 🔹 Sauvegarder le produit en base
        produitService.saveProduit(produit);
    }

    @PutMapping("/update")
    public void updateProduit(@RequestBody Produit p){
      produitService.saveProduit(p);
    }
    @PostMapping("/images")
    public void saveImage(@RequestParam ("file") MultipartFile file) throws IOException {
        produitService.saveImage( file);
    }
    @GetMapping("/image/{id}")
    public byte[] getImage(@PathVariable Long id) throws IOException {
    return produitService.getImage( id);
    }
    @GetMapping("/products/byCat/{id}")
    public List<Produit> getByCat(@PathVariable Long id){
        return produitService.findByCategorieId(id);
    }
}
