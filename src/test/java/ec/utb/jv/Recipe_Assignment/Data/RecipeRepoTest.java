package ec.utb.jv.Recipe_Assignment.Data;

import ec.utb.jv.Recipe_Assignment.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class RecipeRepoTest {

    @Autowired RecipeRepository repository;



}