package ua.pp.darknsoft.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.pp.darknsoft.models.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByDescription(String description);
}
