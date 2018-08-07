package ua.pp.darknsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import ua.pp.darknsoft.commands.IngredientCommand;
import ua.pp.darknsoft.converters.IngredientCommandToIngredient;
import ua.pp.darknsoft.converters.IngredientToIngredientCommand;
import ua.pp.darknsoft.models.Recipe;
import ua.pp.darknsoft.repositories.RecipeRepository;
import ua.pp.darknsoft.repositories.UnitOfMeasureRepository;

import java.util.Optional;

public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientToIngredientCommand ingredientToIngredientCommand;
    @Autowired
    private IngredientCommandToIngredient ingredientCommandToIngredient;
    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if (!recipeOptional.isPresent()) {
            //todo impl error handling
            System.out.println("recipe id not found. Id: " + recipeId);
        }

        Recipe recipe = recipeOptional.get();
        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
                .map(ingredient -> ingredientToIngredientCommand.convert(ingredient)).findFirst();

        if (!ingredientCommandOptional.isPresent()) {
            //todo impl error handling
            System.out.println("Ingredient id not found: " + ingredientId);
        }

        return ingredientCommandOptional.get();
    }
}
