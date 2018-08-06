package ua.pp.darknsoft.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.CategoryCommand;
import ua.pp.darknsoft.models.Category;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {
    private final Object $lock = new Object[0];
    @Autowired
    private RecipeToRecipeCommand recipeConverter;

    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        synchronized ($lock) {
            if (source == null) {
                return null;
            }
            final CategoryCommand categoryCommand = new CategoryCommand();
            categoryCommand.setId(source.getId());
            categoryCommand.setDescription(source.getDescription());
            if (source.getRecipes() != null && source.getRecipes().size() > 0) {
                source.getRecipes().forEach(recipe -> categoryCommand.getRecipes().add(recipeConverter.convert(recipe)));
            }
            return categoryCommand;
        }
    }
}
