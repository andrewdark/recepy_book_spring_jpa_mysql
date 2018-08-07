package ua.pp.darknsoft.services;

import ua.pp.darknsoft.commands.IngredientCommand;

public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
