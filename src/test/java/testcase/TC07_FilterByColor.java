package testcase;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P06_SubCategoryShoesPage;

import static util.Utility.captureScreenshot;

public class TC07_FilterByColor extends TestBase{

    String password = "123456";
    @Test(priority = 1 , description = "filter product in shoes category By Color")
    public void filterProductByColor() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory().selectGreyFilterOption();
        Thread.sleep(1500);

        // TODO: capture screenshot
        captureScreenshot(driver, "FilterProductByColor");

    }
}
