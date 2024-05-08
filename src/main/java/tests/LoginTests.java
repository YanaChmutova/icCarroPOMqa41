package tests;

import dto.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.DataProviders;

public class LoginTests extends BaseTest{

    boolean flag = false;

    @Test
    public void positiveLoginTest() throws InterruptedException {
        searchPage.clickMenu();
        searchPage.openLoginPage();
        loginPage.fillAllLoginFields(user);
        Thread.sleep(3000);// TODO
        Assert.assertTrue(searchPage.validateMyCarsExist());
    }

    @Test(dataProvider = "dataNegativePassword",
            dataProviderClass = DataProviders.class)
    public void negativePasswordLoginTest(String email, String password) throws InterruptedException {
        UserDTO userNP = UserDTO.builder()
                .password(password)
                .username(email)
                .build();
        searchPage.clickMenu();
        searchPage.openLoginPage();
        loginPage.fillAllLoginFields(userNP);
        Thread.sleep(3000);// TODO
        flag = true;
        Assert.assertTrue(loginPage.verifyMessageError("Login or Password incorrect"));
    }

    @AfterMethod
    public void afterMethodPostCond() {
        if(flag) {
            loginPage.clickOkPopUp();
            loginPage.hideKeyBoard();
            loginPage.clickBackBtn();
            flag = false;
        }
    }
}