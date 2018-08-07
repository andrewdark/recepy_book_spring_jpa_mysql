package ua.pp.darknsoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import ua.pp.darknsoft.services.IngredientService;
import ua.pp.darknsoft.services.RecipeService;
import ua.pp.darknsoft.services.UnitOfMeasureService;

@Controller
public class IngredientController {

    private IngredientService ingredientService;
    @Autowired
    private RecipeService recipeService;

    private UnitOfMeasureService unitOfMeasureService;

    @GetMapping("/recipe/{recipeId}/ingredients")
    public String listRecipeIngredient(@PathVariable String recipeId, Model model){
        model.addAttribute("recipe",recipeService.findCommandById(new Long(recipeId)));
        return "recipe/ingredient/list";
    }
    @GetMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }

}
