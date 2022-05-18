import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    // поля класса:
    private final String bumName;
    private final float bumPrice;


    // конструктор с параметрами
    public BunTest(String bumName, float bumPrice) {
        this.bumName = bumName;
        this.bumPrice = bumPrice;

    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTestData() {
        return new Object[][] {
                { "black bun", 100},
                { "white bun", 200},
                { "red bun", 300},
                { "bun", 33.4f },
                { "float bun", 300.34f },
        };
    }
    @Test
    public void parBumNameTest() {
        Bun bun = new Bun(bumName,bumPrice);
        String actualName = bun.getName();
       assertEquals(bumName,actualName);
    }
    @Test
    public void parBumPriceTest() {
        Bun bun = new Bun(bumName,bumPrice);
        float actualPrice = bun.getPrice();
        assertEquals(bumPrice,actualPrice,0);
    }

}
