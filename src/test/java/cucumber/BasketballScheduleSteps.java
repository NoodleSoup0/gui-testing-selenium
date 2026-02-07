package cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketballScheduleSteps {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;

    @Given("I am using Chrome")
    public void i_am_using_chrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Linh Ly\\Documents\\lab-7-gui-testing-20242504-NoodleSoup0\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    @Given("I load the nusports page")
    public void i_load_the_nusports_page() {
        driver.get("https://nusports.com/");
    }

    @When("I load the Women's Basketball schedule")
    public void i_load_the_womens_basketball_schedule() throws InterruptedException {
        Actions moveMouse = new Actions(driver);
        WebElement sportsElement = driver.findElement(By.className("s-text-navigation"));
        moveMouse.moveToElement(sportsElement).perform();

        // wait for the submenu link to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement scheduleLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='level-2-Sports-2']/div/div/ul[2]/li[2]/div/a[2]/span")
        ));

        scheduleLink.click();
    }



    @Then("the schedule should display {string}")
    public void the_schedule_should_display_score(String expectedScore) {
        WebElement scoreElement = driver.findElement(By.xpath("//div[@id='listPanel']/div/div/div/div/div[3]/p/span"));
        assertEquals(expectedScore, scoreElement.getText());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
