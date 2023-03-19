import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private final float bun_price = 666;
    Bun bun = new Bun("summer", bun_price); //создаем тестовую булочку саммер

    //тест для метода получения наименования Булочки
    @Test
    public void checkForReturnabilityOfBunName() {
        Assert.assertEquals("summer", bun.getName());
    }


    //тест для метода получения стоимости Булочки
    @Test
    public void checkForReturnabilityOfBunPrice() {
        Assert.assertEquals(bun_price, bun.getPrice(), 0);
    }
}
