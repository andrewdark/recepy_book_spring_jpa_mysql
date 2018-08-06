package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.IngredientCommand;
import ua.pp.darknsoft.models.Ingredient;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        return null;
    }
}
