package pages;

import dto.UserDTO;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    By inputEmail =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editLoginEmail']");

    By inputPassword =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/editLoginPassword']");

    By btnYalla =
            By.xpath("//*[@resource-id='com.telran.ilcarro:id/loginBtn']");

    By textErrorMessage =
            By.xpath("//*[@resource-id='android:id/message']");

    By alertOkBtn = By.xpath("//*[@resource-id='android:id/button1']");

    public void sendEmail(String email) {
        sendText(inputEmail, email);
    }

    public void sendPassword(String password) {
        sendText(inputPassword, password);
    }

    public void clickYalla() {
        clickBase(btnYalla);
    }

    public void fillAllLoginFields(UserDTO userDTO) {
        sendEmail(userDTO.getUsername());
        sendPassword(userDTO.getPassword());
        clickYalla();
    }

    public boolean verifyMessageError(String str) {
        return getTextBase(textErrorMessage).equals(str);
    }

    public void clickOkPopUp() {
        clickBase(alertOkBtn);
    }
}