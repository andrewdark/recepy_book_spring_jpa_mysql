package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.NotesCommand;
import ua.pp.darknsoft.models.Notes;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {
    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public Notes convert(NotesCommand source) {
        synchronized ($lock) {
            final Notes notes = new Notes();
            notes.setId(source.getId());
            return notes;
        }

    }
}
