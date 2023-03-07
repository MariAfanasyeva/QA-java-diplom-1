import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import resources.ExpectReceipt;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredient;

    @Mock
    Bun bun;

    Burger burger = new Burger();

    @Test
    //проверяем булочки
    public void checkForBuns(){
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    //проверяем метод добавления Ингридиента
    @Test
    public void checkForAddingIngredient(){
        burger.addIngredient(ingredient);
        Assert.assertTrue(burger.ingredients.contains(ingredient));
    }
    //проверяем метод удаления Ингридиента
    @Test
    public void checkForRemovingIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }
    @Mock
    Ingredient ingredient1;
    Ingredient ingredient2;
    //проверяем метод перемещения Ингридиентов (меняем местами)
    @Test
    public void checkForMovingIngredients(){
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        Assert.assertEquals(ingredient1, burger.ingredients.get(1));
    }
    //проверяем метод расчета стоимости
    @Test
    public void checkForGettingPrice(){
        float expectPrice = 555F;
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(155F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Assert.assertEquals(expectPrice, burger.getPrice(), 0);
    }

    @Mock
    Bun summer;
    //проверяем распечатывание чека (вывод) с информацией о рецепте
    @Test
    public void checkForGettingReceipt(){
        //собираем ингридиенты
        burger.addIngredient(ingredient);
        burger.setBuns(summer);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("mulan's sichuan's sauce");
        Mockito.when(summer.getName()).thenReturn("tasty banana bun");
        //формулируем ожидаемый рецепт
        List<String> testBurgerIngredients = new ArrayList<>();
        testBurgerIngredients.add("tasty banana bun");
        testBurgerIngredients.add("mulan's sichuan's sauce");
        ExpectReceipt expectBurger = new ExpectReceipt();
        Assert.assertTrue(expectBurger.buildExpectReceipt(testBurgerIngredients, 0).equals(burger.getReceipt()));
    }
}
