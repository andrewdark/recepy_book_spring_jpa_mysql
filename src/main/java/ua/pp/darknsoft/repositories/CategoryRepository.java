package ua.pp.darknsoft.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.pp.darknsoft.models.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
