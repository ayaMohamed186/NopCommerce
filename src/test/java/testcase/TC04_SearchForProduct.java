package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;

import static util.Utility.captureScreenshot;

public class TC04_SearchForProduct extends TestBase {
    String password = "123456";
    String searchItem = "apple";
    @Test(priority = 1, description = "search for any product")
    public void searchForProduct(){
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P01_HomePage(driver).fillDataInSearchField(searchItem).clickOnSearchBtn();

        new P01_HomePage(driver).waitUntilProductDisplay();
        // TODO: capture screenshot
        captureScreenshot(driver, "SearchForProduct");

        //Assertion
        Assert.assertTrue(new P01_HomePage(driver).validateIfProductsDisplayAfterSearch());

    }
}
