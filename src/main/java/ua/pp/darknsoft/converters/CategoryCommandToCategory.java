package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.CategoryCommand;
import ua.pp.darknsoft.models.Category;

@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {
    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        synchronized ($lock) {
            return null;
        }
    }
}
