package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver() {
        WebDriverManager.chromiumdriver().setup();
        driver.set(new ChromeDriver());
        driver.get().manage().window().setSize(new Dimension(3000, 2000));
    }

    public static void closeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
