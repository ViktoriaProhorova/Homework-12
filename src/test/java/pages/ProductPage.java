package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private By addToCartButton = By.name("add_cart_product");
    private By checkoutButton = By.xpath("//a[text()='Checkout »']");
    private By quantityInCart = By.xpath("//input[@name='quantity']");


    private WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public String getProductsQuantityFromCart() {
        return driver.findElement(quantityInCart).getAttribute("value");
    }
}

