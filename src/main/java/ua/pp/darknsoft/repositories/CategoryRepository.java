package ua.pp.darknsoft.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.pp.darknsoft.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
