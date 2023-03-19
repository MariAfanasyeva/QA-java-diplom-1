import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

//здесь проверяем enum (перечисление с типами ингридиетов)
public class IngredientTypeTest {
    @Test
    public void checkForSauce() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
    }

    @Test
    public void checkForFilling() {
        Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }
}
