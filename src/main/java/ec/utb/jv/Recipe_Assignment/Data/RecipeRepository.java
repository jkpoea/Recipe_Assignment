package ec.utb.jv.Recipe_Assignment.Data;

import ec.utb.jv.Recipe_Assignment.Entity.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    List<Recipe> findByRecipeNameContainingIgnoreCase(String recipeName);

    List<Recipe> findByRecipeByIngredientNameIgnoreCase(String ingredient);

    List<Recipe> findByRecipeByCategoryIgnoreCase(String category);

    List<Recipe> findByRecipeByCategory1OrCategory2OrCategory3IgnoreCase(String category1, String category2,
                                                                         String category3);
}
