import org.testng.Assert;
import org.testng.annotations.Test;


public class TestLogin extends TestBase {
    public static final String LIGHT_PINK = "rgba(255, 204, 204, 1)";
    public static final String LIGHT_GREEN = "rgba(214, 236, 166, 1)";

    @Test
    public void checkSuccessfulLogin() {
        String expectedSuccessMessageText = "You are now logged in as Test Test.";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.attemptLogin("viktoriyaprokhorova7@gmail.com", "250391");

        Assert.assertEquals(homePage.getSuccessMessageText(), expectedSuccessMessageText);
        Assert.assertEquals(homePage.getSuccessMessageBgColor(), LIGHT_GREEN);
        Assert.assertTrue(homePage.successMessageIsVisible(), "Success message is not visible!");
    }

    @Test
    public void checkErrorMessageIfOnlyLoginEntered() {
        String expectedErrorMessageText = "You must provide both email address and password.";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail("bla.bla.bla@gmail.com");
        loginPage.clickLoginButton();

        Assert.assertEquals(homePage.getErrorMessageText(), expectedErrorMessageText);
        Assert.assertEquals(homePage.getErrorMessageBgColor(), LIGHT_PINK);
        Assert.assertTrue(homePage.errorMessageIsVisible(), "Error message is not visible!");
    }

    @Test
    public void checkForgotPasswordIfEmailDoesntExist() {
        String expectedErrorMessageText = "The email address does not exist in our database.";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail("bla.bla.bla@gmail.com");
        loginPage.clickForgotPasswordButton();

        Assert.assertEquals(homePage.getErrorMessageText(), expectedErrorMessageText);
        Assert.assertEquals(homePage.getErrorMessageBgColor(), LIGHT_PINK);
        Assert.assertTrue(homePage.errorMessageIsVisible(), "Error message is not visible!");
    }
}



