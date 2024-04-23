import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestCart extends TestBase {

    @Test
    public void removeFromCartTest() {
        String expectedMessageText = "There are no items in your cart.";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickRedDuckFromMostPopularSection();

        productPage.clickAddToCartButton();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        productPage.clickCheckoutButton();

        String quantityInBasket = productPage.getProductsQuantityFromCart();
        Assert.assertEquals(quantityInBasket, "1");

        cartPage.clickRemoveFromCartButton();

        wait.until(ExpectedConditions.visibilityOf(cartPage.findBackButton()));

        String expectedMessageAfterProductDeletion = cartPage.getEmptyCartMessage();
        Assert.assertEquals(expectedMessageAfterProductDeletion, expectedMessageText);
    }

    @Test
    public void checkDuckPriceIsCorrect() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickRedDuckFromMostPopularSection();

        productPage.clickAddToCartButton();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("span.quantity"), "1"));

        productPage.clickCheckoutButton();

        String redDuckCost = cartPage.getProductPrice();
        Assert.assertEquals(redDuckCost, "$20.00");
    }
}

