package ec.utb.jv.Recipe_Assignment.Data;

import ec.utb.jv.Recipe_Assignment.Entity.Ingredient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IngredientRepoTest {

    @Autowired IngredientRepository repository;

    private List<Ingredient> testList(){
        return Arrays.asList(
                new Ingredient("Rödlök"),
                new Ingredient("Vitlök"),
                new Ingredient("Purjolök"),
                new Ingredient("Lök")
        );
    }

    @BeforeEach
    void setUp(){
        testList().forEach(repository::save);
    }

    @Test
    public void does_it_find_the_correct_onion(){
        String onion = "Lök";
        Optional<Ingredient> result = repository.findByIngredientNameIgnoreCase(onion);
        assertTrue(result.isPresent());
    }

    @Test
    public void does_it_find_all_onions(){
        int expected = 4;
        List<Ingredient> ingredients = repository.findByIngredientNameContainingIgnoreCase("lök");
        assertEquals(expected, ingredients.size());
    }
}
