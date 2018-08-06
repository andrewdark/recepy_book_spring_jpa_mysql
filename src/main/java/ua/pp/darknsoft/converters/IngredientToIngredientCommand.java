package ua.pp.darknsoft.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.IngredientCommand;
import ua.pp.darknsoft.models.Ingredient;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    private final Object $lock = new Object[0];

    @Autowired
    private UnitOfMeasureToUnitOfMeasureCommand uocConverter;
    @Autowired
    private RecipeToRecipeCommand recipeConverter;

    public IngredientToIngredientCommand() {
    }

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.uocConverter = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        synchronized ($lock) {
            if (source == null) {
                return null;
            }
            final IngredientCommand ingredientCommand = new IngredientCommand();
            ingredientCommand.setId(source.getId());
            ingredientCommand.setAmount(source.getAmount());
            ingredientCommand.setDescription(source.getDescription());
            ingredientCommand.setUom(uocConverter.convert(source.getUom()));
            //ingredientCommand.setRecipe(recipeConverter.convert(source.getRecipe()));

            return ingredientCommand;
        }
    }
}
