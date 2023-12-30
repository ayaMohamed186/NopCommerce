package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P06_SubCategoryShoesPage;
import pages.P07_ProductPage;

import static util.Utility.captureScreenshot;

public class TC11_AddProductToCompareList extends TestBase{

    String password = "123456";
    String actualProductAdded;
    @Test(priority = 1 , description = "Add product to shopping cart")
    public void addProductToCompareList() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory();
        //Thread.sleep(1500);
        new P06_SubCategoryShoesPage(driver).addSecondProductToCompareList();
        Thread.sleep(1500);

        // TODO: capture screenshot
        captureScreenshot(driver, "AddProductToCompareList");

        // Assertion
        new P01_HomePage(driver).clickOnComparisonList();
        actualProductAdded = new P07_ProductPage(driver).getProductAddedToCompareList();

        Assert.assertEquals(actualProductAdded , "Nike Floral Roshe Customized Running Shoes");
    }
}
