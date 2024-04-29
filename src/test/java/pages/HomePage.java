package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private By errorMessageLocator = By.cssSelector(".notice.errors");
    private By successMessageLocator = By.cssSelector(".notice.success");

    private By mostPopularSection = By.xpath("//*[@id=\"box-most-popular\"]/h3");
    private By campaignsSection = By.xpath("//*[@id=\"box-campaigns\"]/h3");
    private By latestProductsSection = By.xpath("//*[@id=\"box-campaigns\"]/h3");

    private By redDuckFromMostPopularSection = By.xpath("//h3[text()='Most Popular']/following-sibling::div[@class='content']//a[@title='Red Duck' and div[@class='name']='Red Duck']");

    private By linkToCatalogFromHeader = By.xpath("//*[@id=\"site-menu\"]/ul/li[2]/a");

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkToCatalogFromHeader() {
        driver.findElement(linkToCatalogFromHeader).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessageLocator).getText();
    }

    public String getErrorMessageBgColor() {
        return driver.findElement(errorMessageLocator).getCssValue("background-color");
    }

    public boolean errorMessageIsVisible() {
        return driver.findElement(errorMessageLocator).isDisplayed();
    }

    public String getSuccessMessageText() {
        return driver.findElement(successMessageLocator).getText();
    }

    public String getSuccessMessageBgColor() {
        return driver.findElement(successMessageLocator).getCssValue("background-color");
    }

    public boolean successMessageIsVisible() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }

    public void clickRedDuckFromMostPopularSection() {
        driver.findElement(redDuckFromMostPopularSection).click();
    }
}

