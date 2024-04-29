package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private By removeFromCartButton = By.name("remove_cart_item");
    private By backButton = By.xpath("//a[text()='<< Back']");
    private By emptyCartMessage = By.xpath("//em");

    private By duckPriceFromCart = By.cssSelector("td.unit-cost");


    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    }

//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

    public void clickRemoveFromCartButton() {
        driver.findElement(removeFromCartButton).click();
    }

    public WebElement findBackButton() {
        return driver.findElement(backButton);
    }

    public String getEmptyCartMessage() {
        return driver.findElement(emptyCartMessage).getText();
    }

    public String getProductPrice() {
        return driver.findElement(duckPriceFromCart).getText();
    }

    public void waitingUntilProductIsAddedToCart() {
        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));
    }

    public void waitingUntilBackButtonAppearsOnThePage() {
        wait.until(ExpectedConditions.visibilityOf(findBackButton()));
    }
}

