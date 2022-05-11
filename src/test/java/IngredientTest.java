import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    // поля класса:
    private final String name;;
    private final float price;
    private final IngredientType type;

    // конструктор с параметрами
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTestData() {
        return new Object[][] {
                { SAUCE,"SAUCE test", 33.4f},
                { SAUCE,"SAUCE test", 300.34f},
                { SAUCE,"SAUCE", 300},
                { FILLING,"FILLING", 33.4f},
                { FILLING,"FILLING test", 300.34f},
                { FILLING,"FILLING test", 300},
        };
    }
    @Test
    public void parIngredientNameTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        String actualName = ingredient.getName();
        assertEquals(name,actualName);
    }
    @Test
    public void parIngredientPriceTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        float actualPrice = ingredient.getPrice();
        assertEquals(price,actualPrice,0);
    }
    @Test
    public void parIngredientTypeTest() {
        Ingredient ingredient = new Ingredient(type,name,price);
        IngredientType actualType = ingredient.getType();
        assertEquals(type,actualType);
    }
}
