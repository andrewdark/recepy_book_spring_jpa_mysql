package ua.pp.darknsoft.services;

import ua.pp.darknsoft.commands.RecipeCommand;
import ua.pp.darknsoft.models.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long aLong);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    RecipeCommand findCommandById(Long aLong);

    void deleteById(Long aLong);
}
