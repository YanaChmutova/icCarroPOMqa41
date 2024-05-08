
package tests;

import dto.CarDTO;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends BaseTest{

    @BeforeClass
    public void classPreconditions() {
        searchPage.clickMenu();
        searchPage.openLoginPage();
        loginPage.fillAllLoginFields(user);
    }

    @Test
    public void addNewCarPositive() {
        Random random = new Random();
        String serNum = String.valueOf(random.nextLong(1000000000000L,
                9999999999999L)); //1 0*12
        CarDTO car = CarDTO.builder()
                .serNumber(serNum)
                .manufacture("opel")
                .model("prius")
                .city("Tel Aviv")
                .price(25)
                .carClass("2")
                .fuelType("Gas")
                .year(2019)
                .seats(2)
                .about("about")
                .build();
        searchPage.clickMenu();
        searchPage.clickMyCars();
        myCarsPage.clickAddCar();
        addNewCarPage.addNewCar(car);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(myCarsPage.isSerNumberDisplays(serNum));
    }
}
