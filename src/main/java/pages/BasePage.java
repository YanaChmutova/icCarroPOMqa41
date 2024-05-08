package pages;

import config.AppiumConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.ApplicationCache;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected MobileElement findElementBase(By by) {
        return (MobileElement) AppiumConfig.getDriver().findElement(by);
    }

    protected List<MobileElement> findElements(By by) {
        return AppiumConfig.getDriver().findElements(by);
    }
    protected  String getTextBase(By by) {
        return findElementBase(by).getText().trim();
    }

    protected void wait(By by, int time) {
        new WebDriverWait(AppiumConfig.getDriver(), time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void clickBase(By by) {
        findElementBase(by).click();
    }

    protected void clickByIndex(By by, int i) {
        //findElements(by).get(i).click();
        List<MobileElement> list = findElements(by);
        WebElement elementByIndex = list.get(i);
        elementByIndex.click();
    }

    protected boolean isElementExist(By by) {
        return findElements(by).size() > 0;
    }

    protected void sendText(By by, String text) {
        WebElement element = findElementBase(by);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public void hideKeyBoard() {
        AppiumConfig.getDriver().hideKeyboard();
    }

    public void clickBackBtn() {
        AppiumConfig.getDriver().navigate().back();
    }

    protected void scrollToElement(By by) {
        MobileElement element = findElementBase(by);
        TouchAction touchAction = new TouchAction(AppiumConfig.getDriver());
        touchAction.longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(element))
                        .withDuration(Duration.ofSeconds(2))) // Adjust duration as needed
                .release()
                .perform();;
    }
}