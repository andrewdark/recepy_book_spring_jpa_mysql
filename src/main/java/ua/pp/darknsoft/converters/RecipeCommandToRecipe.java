package ua.pp.darknsoft.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.RecipeCommand;
import ua.pp.darknsoft.models.Recipe;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final Object $lock = new Object[0];

    @Autowired
    private NotesCommandToNotes notesConverter;
    @Autowired
    private CategoryCommandToCategory categoryConverter;
    @Autowired
    private IngredientCommandToIngredient ingredientConverter;

    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        synchronized ($lock) {
            if (source == null) {
                return null;
            }
            final Recipe recipe = new Recipe();
            recipe.setId(source.getId());
            recipe.setDescription(source.getDescription());
            recipe.setPrepTime(source.getPrepTime());
            recipe.setCookTime(source.getCookTime());
            recipe.setServings(source.getServings());
            recipe.setSource(source.getSource());
            recipe.setUrl(source.getUrl());
            recipe.setDirections(source.getDirections());
            recipe.setDifficulty(source.getDifficulty());
            //TO DO
            //recipe.setImage(source.getImage());
            recipe.setNotes(notesConverter.convert(source.getNotes()));
            if (source.getCategories() != null && source.getCategories().size() > 0) {
                source.getCategories().forEach(category -> recipe.getCategories().add(categoryConverter.convert(category)));
            }
            if (source.getIngredients() != null && source.getIngredients().size() > 0) {
                source.getIngredients().forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
            }
            return recipe;
        }

    }
}
