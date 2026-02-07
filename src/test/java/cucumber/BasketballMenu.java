package cucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketballMenu {

    private WebDriver driver;

    public BasketballMenu(WebDriver driver) {
        this.driver = driver;
    }

    public BasketballSchedule navigateToSchedule() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement scheduleLink = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//div[@id='level-2-Sports-2']/div/div/ul[2]/li[2]/div/a[2]/span")
                )
        );

        scheduleLink.click();

        return new BasketballSchedule(driver);
    }
}
