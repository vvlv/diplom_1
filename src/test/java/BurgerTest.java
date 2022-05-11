import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

//@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    //@Mock
    Burger burger = new Burger();

    Bun baseBun = new Bun("base bun",100);
    Bun blackBun = new Bun("black bun",105.50f);
    Ingredient cutlet = new Ingredient(FILLING,"cutlet",135.45f);
    Ingredient originalSauce = new Ingredient(SAUCE,"original sauce",40);
    Ingredient onion = new Ingredient(FILLING,"onion",15);
    Ingredient tomato = new Ingredient(FILLING,"tomato",30);
    @Test
    public void baseBunPriceTest () {
        burger.setBuns(baseBun);
        assertEquals(baseBun.getPrice()*2,burger.getPrice(),0);
    }
    @Test
    public void blackBunPriceTest () {
        burger.setBuns(blackBun);
        assertEquals(blackBun.getPrice()*2,burger.getPrice(),0);
    }

    @Test
    public void baseBurgerPriceTest () {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        assertEquals(blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice(),burger.getPrice(),0);
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
        StringBuilder BaseBurgerReceipt = new StringBuilder(String.format("(==== %s ====)%n", blackBun.getName()));

        for (Ingredient ingredient : ingredientsTest) {
            BaseBurgerReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        BaseBurgerReceipt.append(String.format("(==== %s ====)%n", blackBun.getName()));
        BaseBurgerReceipt.append(String.format("%nPrice: %f%n", blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice()+onion.getPrice()));


        assertEquals(BaseBurgerReceipt.toString(),burger.getReceipt());
    }
    @Test
    public void burgerIngredientRemoveTest () {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        burger.addIngredient(onion);
        burger.removeIngredient(3);
        assertEquals(blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice(),burger.getPrice(),0);
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

        StringBuilder BaseBurgerReceipt = new StringBuilder(String.format("(==== %s ====)%n", blackBun.getName()));

        for (Ingredient ingredient : ingredientsTest) {
            BaseBurgerReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        BaseBurgerReceipt.append(String.format("(==== %s ====)%n", blackBun.getName()));
        BaseBurgerReceipt.append(String.format("%nPrice: %f%n", blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice()));


        assertEquals(BaseBurgerReceipt.toString(),burger.getReceipt());
    }
    @Test
    public void burgerIngredientMove_PriceTest () {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(originalSauce);
        burger.addIngredient(tomato);
        burger.addIngredient(onion);
        burger.moveIngredient(3,1);
        assertEquals(blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice()+onion.getPrice(),burger.getPrice(),0);
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

        StringBuilder BaseBurgerReceipt = new StringBuilder(String.format("(==== %s ====)%n", blackBun.getName()));

        for (Ingredient ingredient : ingredientsTest) {
            BaseBurgerReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        BaseBurgerReceipt.append(String.format("(==== %s ====)%n", blackBun.getName()));
        BaseBurgerReceipt.append(String.format("%nPrice: %f%n", blackBun.getPrice()*2+cutlet.getPrice()+originalSauce.getPrice()+tomato.getPrice()+onion.getPrice()));


        assertEquals(BaseBurgerReceipt.toString(),burger.getReceipt());
    }
}
