package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogPage {

    private By filterButtonName = By.xpath("//a[@class='button' and text()='Name']");
    private By filterButtonPrice = By.xpath("//a[@class='button' and text()='Price']");
    private By filterButtonPopularity = By.xpath("//a[@class='button' and text()='Popularity']");
    private By filterButtonDate = By.xpath("//a[@class='button' and text()='Date']");

    private By activeFilterButtonName = By.xpath("//span[@class='button active' and text()='Name']");
    private By activeFilterButtonPrice = By.xpath("//span[@class='button active' and text()='Price']");
    private By activeFilterButtonPopularity = By.xpath("//span[@class='button active' and text()='Popularity']");
    private By activeFilterButtonDate = By.xpath("//span[@class='button active' and text()='Date']");


    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFilterButtonName() {
        driver.findElement(filterButtonName).click();
    }

    public void clickFilterButtonPrice() {
        driver.findElement(filterButtonPrice).click();
    }

    public void clickFilterButtonPopularity() {
        driver.findElement(filterButtonPopularity).click();
    }

    public void clickFilterButtonDate() {
        driver.findElement(filterButtonDate).click();
    }

    public boolean filterButtonNameIsActive() {
        return driver.findElement(activeFilterButtonName).isDisplayed();
    }

    public boolean filterButtonPriceIsActive() {
        return driver.findElement(activeFilterButtonPrice).isDisplayed();
    }

    public boolean filterButtonPopularityIsActive() {
        return driver.findElement(activeFilterButtonPopularity).isDisplayed();
    }

    public boolean filterButtonDateIsActive() {
        return driver.findElement(activeFilterButtonDate).isDisplayed();
    }
}
