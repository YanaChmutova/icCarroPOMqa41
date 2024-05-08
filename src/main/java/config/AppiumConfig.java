package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {
    private static AppiumDriver<MobileElement> driver = null;

    @BeforeSuite
    private static AppiumDriver init() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pix3");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
        capabilities.setCapability("appPackage", "com.telran.ilcarro");
        capabilities.setCapability("appActivity", ".SplashActivity");

        capabilities.setCapability("app",
                "C:\\Tools\\ilcarro-android.apk");
// windows like: C:\\Tools\\ilcarro-android.apk

        try {
            driver = new AppiumDriver<>(
                    new URL("http://localhost:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;
    }

    @AfterSuite
    private static void tearDown() {
        driver.quit();
    }

    public static AppiumDriver getDriver() {
        if(driver == null) {
            driver = init();
        }
        return driver;
    }
    // singleton
    // fabric

    /*
        private volatile static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation from outside
    }

    public static Singleton getInstance() {
        if (instance == null) { // First check
            synchronized (Singleton.class) {
                if (instance == null) { // Double check
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
     */
}