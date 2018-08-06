package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import ua.pp.darknsoft.commands.UnitOfMeasureCommand;
import ua.pp.darknsoft.models.UnitOfMeasure;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {
    private final Object $lock = new Object[0];

    @Nullable
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        synchronized ($lock) {
            if (source == null) return null;
            final UnitOfMeasure uom = new UnitOfMeasure();
            uom.setId(source.getId());
            uom.setDescription(source.getDescription());
            return uom;
        }

    }
}
