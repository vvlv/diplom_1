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
    private final boolean expected;

    // конструктор с параметрами
    public BunTest(String bumName, float bumPrice, boolean expected) {
        this.bumName = bumName;
        this.bumPrice = bumPrice;
        this.expected = expected;
    }

    @Parameterized.Parameters // добавили аннотацию
    public static Object[][] getTestData() {
        return new Object[][] {
                { "black bun", 100,true},
                { "white bun", 200,true},
                { "red bun", 300,true},
                { "bun", 33.4f ,true},
                { "float bun", 300.34f ,true},
        };
    }
    @Test
    public void parBumNameTest() {
        Bun bun = new Bun(bumName,bumPrice);
        String actualName = bun.getName();
       assertEquals(expected,actualName==bumName);
    }
    @Test
    public void parBumPriceTest() {
        Bun bun = new Bun(bumName,bumPrice);
        float actualPrice = bun.getPrice();
        assertEquals(expected,actualPrice==bumPrice);
    }

}
