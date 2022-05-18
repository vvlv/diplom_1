import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    //@Mock
    Burger burger = new Burger();

    Bun baseBun = new Bun("base bun",100);
    Bun blackBun = new Bun("black bun",105.50f);
    Ingredient cutlet = new Ingredient(FILLING,"cutlet",135.45f);
    Ingredient originalSauce = new Ingredient(SAUCE,"original sauce",40);
    Ingredient onion = new Ingredient(FILLING,"onion",15);
    Ingredient tomato = new Ingredient(FILLING,"tomato",30);

    @Test
    public void bunsSetPriceTest () {

        Mockito.when(bun.getPrice()).thenReturn(115.23f);
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(115.23f,bun.getPrice(),0);
    }
    @Test
    public void bunsSetNameTest () {
        Mockito.when(bun.getName()).thenReturn("juicy bun");

        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals("juicy bun",bun.getName());
    }
    @Test
    public void ingredientSetTest () {
        Mockito.when(ingredient.getPrice()).thenReturn(112.3f);
        Mockito.when(ingredient.getName()).thenReturn("ingredient bun");
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue(ingredient.getName().equals("ingredient bun")&&ingredient.getType().equals(SAUCE)&&ingredient.getPrice()==112.3f);
    }
    @Test
    public void baseBunPriceTest () {
        burger.setBuns(bun);
        assertEquals(bun.getPrice()*2,burger.getPrice(),0);
    }

    @Test
    public void baseBurgerPriceTest () {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        float burgerPrice = blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice();
        assertEquals(burgerPrice,burger.getPrice(),0);
    }

    @Test
    public void getBaseBurgerReceiptTest (){
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        burger.addIngredient(onion);
        List<Ingredient> ingredientsTest = new ArrayList<>();
        ingredientsTest.add(cutlet);
        ingredientsTest.add(originalSauce);
        ingredientsTest.add(tomato);
        ingredientsTest.add(onion);
        float burgerPrice = blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice()+onion.getPrice();
        assertEquals(receiptTestMethodGenerate(ingredientsTest,burgerPrice),burger.getReceipt());
    }
    @Test
    public void burgerIngredientRemoveTest () {

        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        burger.addIngredient(onion);
        burger.removeIngredient(3);
        float burgerPrice = blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice();
        assertEquals(burgerPrice,burger.getPrice(),0);
    }
    @Test
    public void burgerIngredientRemoveReceiptTest (){

        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        burger.addIngredient(onion);
        List<Ingredient> ingredientsTest = new ArrayList<>();
        ingredientsTest.add(cutlet);
        ingredientsTest.add(originalSauce);
        ingredientsTest.add(tomato);
        ingredientsTest.add(onion);
        ingredientsTest.remove(3);
        burger.removeIngredient(3);
        float burgerPrice = blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice();
        assertEquals(receiptTestMethodGenerate(ingredientsTest,burgerPrice),burger.getReceipt());
    }
    @Test
    public void burgerIngredientMove_PriceTest () {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        burger.addIngredient(onion);
        burger.moveIngredient(3,1);
        float burgerPrice = blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice()+onion.getPrice();
        assertEquals(burgerPrice,burger.getPrice(),0);
    }
    @Test
    public void burgerIngredientMove_ReceiptTest (){

        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        burger.addIngredient(onion);
        List<Ingredient> ingredientsTest = new ArrayList<>();
        ingredientsTest.add(cutlet);
        ingredientsTest.add(onion);
        ingredientsTest.add(originalSauce);
        ingredientsTest.add(tomato);
        burger.moveIngredient(3,1);
        float burgerPrice = blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice()+onion.getPrice();
        assertEquals(receiptTestMethodGenerate(ingredientsTest,burgerPrice),burger.getReceipt());
    }

    //Метод для генерации чек с данными объявленными в начале класса
    public String receiptTestMethodGenerate (List<Ingredient> ingredientsTest,float receiptPrice) {
        StringBuilder BaseBurgerReceipt = new StringBuilder(String.format("(==== %s ====)%n", blackBun.getName()));

        for (Ingredient ingredient : ingredientsTest) {
            BaseBurgerReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        BaseBurgerReceipt.append(String.format("(==== %s ====)%n", blackBun.getName()));
        BaseBurgerReceipt.append(String.format("%nPrice: %f%n", receiptPrice));
return BaseBurgerReceipt.toString();
    }
}
