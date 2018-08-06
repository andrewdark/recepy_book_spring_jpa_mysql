package ua.pp.darknsoft.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.IngredientCommand;
import ua.pp.darknsoft.models.Ingredient;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    private final Object $lock = new Object[0];

    @Autowired
    private UnitOfMeasureCommandToUnitOfMeasure uocConverter;
    @Autowired
    private RecipeCommandToRecipe recipeConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure) {
        this.uocConverter = unitOfMeasureCommandToUnitOfMeasure;
    }

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        synchronized ($lock) {
            if (source == null) {
                return null;
            }
            final Ingredient ingredient = new Ingredient();
            ingredient.setId(source.getId());
            ingredient.setAmount(source.getAmount());
            ingredient.setDescription(source.getDescription());
            ingredient.setUom(uocConverter.convert(source.getUom()));
            //ingredient.setRecipe(recipeConverter.convert(source.getRecipe()));
            return ingredient;
        }
    }
}
