package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.pp.darknsoft.services.RecipeService;

@Controller
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("test","test2");
        model.addAttribute("recipe",recipeService.findById(new Long(id)));
        return "recipe/show";
    }
}
