import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {
    Database db = Mockito.mock(Database.class);



    @Test
    public void availableBunsTest () {
        db.availableBuns();
        Mockito.verify(db).availableBuns();
    }
    @Test
    public void availableIngredientsTest () {
        db.availableIngredients();
        Mockito.verify(db).availableIngredients();
    }
    @Test
    public void availableIngredients_dataTest () {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient(IngredientType.FILLING, "cutlet", 100));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "test", 200));
        ingredients.add(new Ingredient(IngredientType.SAUCE, "testFloat", 200.50f));

        Mockito.when(db.availableIngredients()).thenReturn(ingredients);
        assertEquals(ingredients,db.availableIngredients());

    }
    @Test
    public void availableBuns_dataTest () {
        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("тест", 10));
        buns.add(new Bun("test", 300));
        buns.add(new Bun("red bun", 150.78f));

        Mockito.when(db.availableBuns()).thenReturn(buns);
        assertEquals(buns,db.availableBuns());

    }
}
