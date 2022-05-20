import org.junit.Test;

import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

//@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {
    //Database db = Mockito.mock(Database.class);
    Database db = new Database();



    @Test
    public void availableBunsTest () {
        db.availableBuns();
        assertNotNull(db.availableBuns());
       // Mockito.verify(db).availableBuns();
    }
    @Test
    public void availableIngredientsTest () {
        db.availableIngredients();
        assertNotNull(db.availableIngredients());
    }

    @Test
    public void availableIngredients_dataTest () {
        List<Ingredient> ingredients = new ArrayList<>();
        List<Ingredient> ingredientsDB = db.availableIngredients();
        ingredients.add(new Ingredient(IngredientType.SAUCE, "hot sauce", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "sour cream", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "chili sauce", 300));

        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.FILLING, "dinosaur", 200));
        ingredients.add(new Ingredient(IngredientType.FILLING, "sausage", 300));


        assertEquals(ingredients,ingredientsDB);
        //assertEquals(ingredients,db.availableIngredients());

    }

    @Test
    public void availableBuns_dataTest () {
        List<Bun> buns = new ArrayList<>();
        List<Bun> bunsDB = db.availableBuns();
        buns.add(new Bun("black bun", 100));
        buns.add(new Bun("white bun", 200));
        buns.add(new Bun("red bun", 300));
        assertEquals(bunsDB,buns);
    }
    @Test
    public void availableBunsNotNullTest () {
        Database database = new Database();
        assertNotNull(database.availableBuns());
    }
    @Test
    public void availableIngredientsNotNullTest () {
        Database database = new Database();
        assertNotNull(database.availableIngredients());
    }
}
