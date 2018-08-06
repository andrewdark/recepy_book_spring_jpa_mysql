package ua.pp.darknsoft.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.CategoryCommand;
import ua.pp.darknsoft.models.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    private final Object $lock = new Object[0];
    @Autowired
    private RecipeCommandToRecipe recipeConverter;

    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        synchronized ($lock) {
            if (source == null) {
                return null;
            }
            final Category category = new Category();
            category.setId(source.getId());
            category.setDescription(source.getDescription());
            if (source.getRecipes() != null && source.getRecipes().size() > 0) {
                source.getRecipes().forEach(recipe -> category.getRecipes().add(recipeConverter.convert(recipe)));
            }
            return category;
        }
    }
}
