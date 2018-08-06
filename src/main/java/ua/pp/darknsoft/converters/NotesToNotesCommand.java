package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.NotesCommand;
import ua.pp.darknsoft.models.Notes;

@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {
    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public NotesCommand convert(Notes source) {
        synchronized ($lock) {
            return null;
        }
    }
}
