package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.IngredientCommand;
import ua.pp.darknsoft.models.Ingredient;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        synchronized ($lock) {
            return null;
        }
    }
}
