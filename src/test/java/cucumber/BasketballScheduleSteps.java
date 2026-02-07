package cucumber;

import io.cucumber.java.en.*;
import io.cucumber.java.After;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketballScheduleSteps {

    private WebDriver driver;
    private BasketballSchedule schedule;

    @Given("I am using Chrome")
    public void i_am_using_chrome() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\Linh Ly\\Documents\\lab-7-gui-testing-20242504-NoodleSoup0\\chromedriver.exe"
        );

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("I load the nusports page")
    public void i_load_the_nusports_page() {
        driver.get("https://nusports.com/");
    }

    @When("I load the Women's Basketball schedule")
    public void i_load_the_womens_basketball_schedule() {
        SportsMenu sportsMenu = new SportsMenu(driver);
        BasketballMenu basketballMenu = sportsMenu.navigateToBasketballMenu();
        schedule = basketballMenu.navigateToSchedule();
    }

    @Then("the schedule should display {string}")
    public void the_schedule_should_display(String expectedScore) {
        assertEquals(expectedScore, schedule.getScore());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
