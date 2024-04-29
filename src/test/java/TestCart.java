import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;


public class TestCart extends TestBase {

    @Test
    public void removeFromCartTest() {
        String expectedMessageText = "There are no items in your cart.";

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickRedDuckFromMostPopularSection();

        productPage.clickAddToCartButton();

        cartPage.waitingUntilProductIsAddedToCart();

        productPage.clickCheckoutButton();

        String quantityInBasket = productPage.getProductsQuantityFromCart();
        Assert.assertEquals(quantityInBasket, "1");

        cartPage.clickRemoveFromCartButton();

        cartPage.waitingUntilBackButtonAppearsOnThePage();

        String expectedMessageAfterProductDeletion = cartPage.getEmptyCartMessage();
        Assert.assertEquals(expectedMessageAfterProductDeletion, expectedMessageText);
    }

    @Test
    public void checkDuckPriceIsCorrect() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.clickRedDuckFromMostPopularSection();

        productPage.clickAddToCartButton();
        cartPage.waitingUntilProductIsAddedToCart();
        productPage.clickCheckoutButton();

        String redDuckCost = cartPage.getProductPrice();
        Assert.assertEquals(redDuckCost, "$20.00");
    }
}

