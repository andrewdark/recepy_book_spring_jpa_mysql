package ua.pp.darknsoft.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.pp.darknsoft.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
