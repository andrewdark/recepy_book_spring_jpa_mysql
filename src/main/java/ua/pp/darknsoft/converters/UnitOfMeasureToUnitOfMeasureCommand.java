package ua.pp.darknsoft.converters;

import org.springframework.core.convert.converter.Converter;
import ua.pp.darknsoft.commands.UnitOfMeasureCommand;
import ua.pp.darknsoft.models.UnitOfMeasure;

public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure,UnitOfMeasureCommand> {
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null) return null;
        final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
        uomc.setId(source.getId());
        uomc.setDescription(source.getDescription());
        return uomc;
    }
}
