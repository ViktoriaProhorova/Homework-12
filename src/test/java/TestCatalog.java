import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCatalog extends TestBase {

    @Test
    public void checkFilterButtonsBecomeActiveAfterClicking() {
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);

        homePage.clickLinkToCatalogFromHeader();

        catalogPage.clickFilterButtonName();
        Assert.assertTrue(catalogPage.filterButtonNameIsActive(),
                "Filter button 'Name' is not active after clicking.");

        catalogPage.clickFilterButtonPrice();
        Assert.assertTrue(catalogPage.filterButtonPriceIsActive(),
                "Filter button 'Price' is not active after clicking.");

        catalogPage.clickFilterButtonPopularity();
        Assert.assertTrue(catalogPage.filterButtonPopularityIsActive(),
                "Filter button 'Popularity' is not active after clicking.");

        catalogPage.clickFilterButtonDate();
        Assert.assertTrue(catalogPage.filterButtonDateIsActive(),
                "Filter button 'Date' is not active after clicking.");
    }

}
