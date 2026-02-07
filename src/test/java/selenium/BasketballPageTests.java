package selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketballPageTests {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @BeforeEach
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Linh Ly\\Documents\\lab-7-gui-testing-20242504-NoodleSoup0\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @Test
    public void testBasketballPageTests() throws Exception {
        driver.get("https://nusports.com/");

        Actions moveMouse = new Actions(driver);
        WebElement sportsElement = driver.findElement(By.className("s-text-navigation"));
        moveMouse.moveToElement(sportsElement).perform();

        // wait for the submenu link to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement scheduleLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='level-2-Sports-2']/div/div/ul[2]/li[2]/div/a[2]/span")
        ));

        scheduleLink.click();

//        driver.findElement(By.xpath("//div[@id='listPanel']/div/div/div/div/div[3]/p/span")).click();
        assertEquals("W, 82-49", driver.findElement(By.xpath("//div[@id='listPanel']/div/div/div/div/div[3]/p/span")).getText());
    }

    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
