import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By emailInputLocator = By.name("email");
    private By passwordInputLocator = By.name("password");
    private By loginButtonLocator = By.name("login");
    private By lostPasswordButtonLocator = By.name("lost_password");

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void attemptLogin(String username, String password) {
        driver.findElement(emailInputLocator).sendKeys(username);
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
    }

    public void enterEmail(String username) {
        driver.findElement(emailInputLocator).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInputLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

    public void clickForgotPasswordButton() {
        driver.findElement(lostPasswordButtonLocator).click();
    }
}

