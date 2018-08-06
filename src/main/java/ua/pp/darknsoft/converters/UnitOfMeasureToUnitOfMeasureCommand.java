package ua.pp.darknsoft.converters;

import org.hibernate.annotations.Synchronize;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.UnitOfMeasureCommand;
import ua.pp.darknsoft.models.UnitOfMeasure;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {
    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        synchronized ($lock) {
            if (source == null) return null;
            final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
            uomc.setId(source.getId());
            uomc.setDescription(source.getDescription());
            return uomc;
        }

    }
}
