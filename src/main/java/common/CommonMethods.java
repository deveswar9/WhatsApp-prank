package common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;

    public static WebDriver launch() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://web.whatsapp.com/");
        driver.manage().window().maximize();
        Thread.sleep(20000);
        return driver;
    }

    public static void waitForElementToBeVisible(String element, Duration timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        //wait.until(ExpectedConditions.visibilityOf(By.xpath(element)));
    }

    public static void clickElement(String locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        element.click();
    }

    public static void enterText(String locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        element.clear();
        element.sendKeys(text);
    }
}
