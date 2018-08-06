package ua.pp.darknsoft.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.NotesCommand;
import ua.pp.darknsoft.models.Notes;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    private final Object $lock = new Object[0];

    @Autowired
    private RecipeCommandToRecipe recipeConverter;

    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        synchronized ($lock) {
            if (source == null) {
                return null;
            }
            final Notes notes = new Notes();
            notes.setId(source.getId());
            notes.setRecipeNotes(source.getRecipeNotes());
            //notes.setRecipe(recipeConverter.convert(source.getRecipe()));
            return notes;
        }

    }
}
