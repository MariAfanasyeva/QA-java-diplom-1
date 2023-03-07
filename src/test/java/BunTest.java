import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("summer",666); //создаем тестовую булочку саммер
    //тест для метода получения наименования Булочки
    @Test
    public void checkForReturnabilityOfBunName(){
        Assert.assertEquals("summer", bun.getName());
    }


    //тест для метода получения стоимости Булочки
    @Test
    public void checkForReturnabilityOfBunPrice(){
        Assert.assertEquals(666, bun.getPrice(),0);
    }
}
