package ua.pp.darknsoft.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.NotesCommand;
import ua.pp.darknsoft.models.Notes;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    private final Object $lock = new Object[0];

    @Autowired
    private RecipeToRecipeCommand recipeConverter;

    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        synchronized ($lock) {
            if (source == null) {
                return null;
            }
            final NotesCommand notesCommand = new NotesCommand();
            notesCommand.setId(source.getId());
            notesCommand.setRecipeNotes(source.getRecipeNotes());
           // notesCommand.setRecipe(recipeConverter.convert(source.getRecipe()));
            return notesCommand;
        }
    }
}
