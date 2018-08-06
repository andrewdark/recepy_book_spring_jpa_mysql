package ua.pp.darknsoft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.darknsoft.commands.RecipeCommand;
import ua.pp.darknsoft.converters.RecipeCommandToRecipe;
import ua.pp.darknsoft.converters.RecipeToRecipeCommand;
import ua.pp.darknsoft.models.Recipe;
import ua.pp.darknsoft.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RecipeCommandToRecipe recipeCommandToRecipe;
    @Autowired
    private RecipeToRecipeCommand recipeToRecipeCommand;


    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

    @Override
    public Recipe findById(Long aLong) {
        //Optional<Recipe> optionalRecipe = recipeRepository.findById(aLong);
        return recipeRepository.findById(aLong).get();
    }

    @Transactional
    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe savedRecipe = recipeRepository.save(recipeCommandToRecipe.convert(command));
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
