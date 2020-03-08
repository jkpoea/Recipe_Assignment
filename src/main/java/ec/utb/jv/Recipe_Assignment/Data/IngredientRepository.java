package ec.utb.jv.Recipe_Assignment.Data;

import ec.utb.jv.Recipe_Assignment.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    Optional<Ingredient> findByIngredientNameIgnoreCase(String ingredientName);
    List<Ingredient> findByIngredientNameContainingIgnoreCase(String string);
}
