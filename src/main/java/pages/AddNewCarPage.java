
package pages;

import dto.CarDTO;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class AddNewCarPage extends BasePage{

    By inputSerNumber =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editSerial']");
    By inputManufacture =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editMan']");
    By inputModel =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editModel']");
    By inputCity =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editCity']");
    By inputPrice =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editPrice']");
    By inputCarClass =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editCarClass']");
    By inputFuel =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/text1']");
    By inputYear =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editYear']");
    By inputSeats =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editSeats']");
    By inputAbout =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editAbout']");
    By btnAddCar =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/addCarBtn']");

    By fuelDiesel = By.xpath("//*[@text='Diesel']");

    public void addNewCar(CarDTO car) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sendText(inputSerNumber, car.getSerNumber());
        sendText(inputManufacture, car.getManufacture());
        sendText(inputModel, car.getModel());
        hideKeyBoard();
        sendText(inputCity, car.getCity());
        hideKeyBoard();
        sendText(inputPrice, String.valueOf(car.getPrice()));
        hideKeyBoard();
        sendText(inputCarClass, car.getCarClass());
        hideKeyBoard();
        //sendText(inputFuel, car.getFuelType());

        clickBase(inputFuel);
        clickBase(fuelDiesel);
        //-------------
        hideKeyBoard();
        sendText(inputYear, String.valueOf(car.getYear()));
        hideKeyBoard();
        sendText(inputSeats, String.valueOf(car.getSeats()));
        hideKeyBoard();
        sendText(inputAbout, car.getAbout());
        hideKeyBoard();
        clickBase(btnAddCar);
    }
}
