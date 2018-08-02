package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ua.pp.darknsoft.models.Category;
import ua.pp.darknsoft.models.Recipe;
import ua.pp.darknsoft.models.UnitOfMeasure;
import ua.pp.darknsoft.repositories.CategoryRepository;
import ua.pp.darknsoft.repositories.RecipeRepository;
import ua.pp.darknsoft.repositories.UnitOfMeasureRepository;
import ua.pp.darknsoft.services.RecipeService;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping({"", "/", "index"})
    public String index(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
