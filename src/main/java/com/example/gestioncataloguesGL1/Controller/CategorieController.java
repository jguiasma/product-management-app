package com.example.gestioncataloguesGL1.Controller;

import com.example.gestioncataloguesGL1.Entities.Categorie;
import com.example.gestioncataloguesGL1.Repositories.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Indique que cette classe est un contrôleur REST
@RequestMapping("/api") // Le préfixe commun à tous les endpoints de ce contrôleur
@CrossOrigin("*") // Autorise les requêtes depuis n’importe quelle origine (utile pour le front-end)
@AllArgsConstructor // Génère automatiquement un constructeur avec tous les arguments (ici categorieRepository)
public class CategorieController {

    private final CategorieRepository categorieRepository;

    // Endpoint pour récupérer toutes les catégories
    @GetMapping("/categories")
    public List<Categorie> getCategories() {
        return categorieRepository.findAll(); // Retourne la liste de toutes les catégories
    }
}
