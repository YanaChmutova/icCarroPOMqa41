
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void positiveLoginTest() throws InterruptedException {
        searchPage.clickMenu();
        searchPage.openLoginPage();
        loginPage.positiveLogin(user);
        Thread.sleep(3000);// TODO
        Assert.assertTrue(searchPage.validateMyCarsExist());
    }
}
