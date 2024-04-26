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

    public void sendEmail(String email) {
        sendText(inputEmail, email);
    }

    public void sendPassword(String password) {
        sendText(inputPassword, password);
    }

    public void clickYalla() {
        clickBase(btnYalla);
    }

    public void positiveLogin(UserDTO userDTO) {
        sendEmail(userDTO.getUsername());
        sendPassword(userDTO.getPassword());
        clickYalla();
    }

}