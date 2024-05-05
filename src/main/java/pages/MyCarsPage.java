
package pages;

import org.openqa.selenium.By;

public class MyCarsPage extends BasePage{

    By btnAddNewCar =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/addCarBtn']");
    String serNum = "";
    By serNumber = By.xpath("//*[@text='"+serNum+"']");

    public void clickAddCar() {
        clickBase(btnAddNewCar);
    }

    public boolean isSerNumberDisplays(String serialNumberStr) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        serNum = serialNumberStr;
        return isElementExist(serNumber);
    }
}
