import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private By removeFromCartButton = By.name("remove_cart_item");
    private By backButton = By.xpath("//a[text()='<< Back']");
    private By emptyCartMessage = By.xpath("//em");

    private By duckPriceFromCart = By.cssSelector("td.unit-cost");


    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

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
}

