package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.pp.darknsoft.models.Category;
import ua.pp.darknsoft.models.UnitOfMeasure;
import ua.pp.darknsoft.repositories.CategoryRepository;
import ua.pp.darknsoft.repositories.RecipeRepository;
import ua.pp.darknsoft.repositories.UnitOfMeasureRepository;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @GetMapping({"", "/", "index"})
    public String index() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("category id: " + categoryOptional.get().getId());
        return "index";
    }
}
