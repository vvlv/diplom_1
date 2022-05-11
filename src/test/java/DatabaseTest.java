import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Database;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseTest {
    @Mock
    Database db;


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
}
