package cucumber;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class SportsMenu {

    private WebDriver driver;

    public SportsMenu(WebDriver driver) {
        this.driver = driver;
    }

    public BasketballMenu navigateToBasketballMenu() {
        Actions actions = new Actions(driver);

        WebElement sportsElement = driver.findElement(By.className("s-text-navigation"));
        actions.moveToElement(sportsElement).perform();

        WebElement basketballLink = driver.findElement(
                By.xpath("//div[@id='level-2-Sports-2']/div/div/ul[2]/li[2]/div/a[2]/span")
        );

        basketballLink.click();

        return new BasketballMenu(driver);
    }
}
