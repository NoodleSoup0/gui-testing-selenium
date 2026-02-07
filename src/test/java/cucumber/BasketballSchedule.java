package cucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasketballSchedule {

    private WebDriver driver;

    public BasketballSchedule(WebDriver driver) {
        this.driver = driver;
    }

    public String getScore() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement scoreElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@id='listPanel']/div/div/div/div/div[3]/p/span")
                )
        );

        return scoreElement.getText();
    }
}
