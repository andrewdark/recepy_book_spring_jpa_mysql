package ua.pp.darknsoft.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.RecipeCommand;
import ua.pp.darknsoft.models.Recipe;

@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {
    private final Object $lock = new Object[0];

    @Autowired
    private NotesToNotesCommand notesConverter;
    @Autowired
    private CategoryToCategoryCommand categoryConverter;
    @Autowired
    private IngredientToIngredientCommand ingredientConverter;

    @Nullable
    @Override
    public RecipeCommand convert(Recipe source) {
        synchronized ($lock) {
            if (source == null) {
                return null;
            }
            final RecipeCommand recipeCommand = new RecipeCommand();
            recipeCommand.setId(source.getId());
            recipeCommand.setDescription(source.getDescription());
            recipeCommand.setPrepTime(source.getPrepTime());
            recipeCommand.setCookTime(source.getCookTime());
            recipeCommand.setServings(source.getServings());
            recipeCommand.setSource(source.getSource());
            recipeCommand.setUrl(source.getUrl());
            recipeCommand.setDirections(source.getDirections());
            recipeCommand.setDifficulty(source.getDifficulty());
            //TO DO
            //recipe.setImage(source.getImage());
            recipeCommand.setNotes(notesConverter.convert(source.getNotes()));
            if (source.getCategories() != null && source.getCategories().size() > 0) {
                source.getCategories().forEach(category -> recipeCommand.getCategories().add(categoryConverter.convert(category)));
            }
            if (source.getIngredients() != null && source.getIngredients().size() > 0) {
                source.getIngredients().forEach(ingredient -> recipeCommand.getIngredients().add(ingredientConverter.convert(ingredient)));
            }
            return recipeCommand;
        }
    }
}
