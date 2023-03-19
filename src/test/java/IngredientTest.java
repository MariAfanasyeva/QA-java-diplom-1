import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Состав ингридиентов бургера: соус и начинка. Тестовые данные: {0} {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "morty's chocolate dreams", 77},
                {IngredientType.FILLING, "cucumber Rick", 777},
        };
    }

    @Test
    //проверяем состав нашего бургера
    public void checkForIngredientsComposition() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(ingredientType, ingredient.getType());
        Assert.assertEquals(name, ingredient.getName());
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }
}
