package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static util.Utility.captureScreenshot;

public class TC11_AddProductToCompareList extends TestBase{

    String password = "123456";
    String actualProductAdded;
    @Test(priority = 1 , description = "Add product to shopping cart")
    public void addProductToCompareList() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory();
        new P06_SubCategoryShoesPage(driver).addSecondProductToCompareList();

        Thread.sleep(2000);

        new P01_HomePage(driver).clickOnComparisonList();
        actualProductAdded = new P09_ComparisonListPage(driver).getProductAddedToCompareList();

        // TODO: capture screenshot
        captureScreenshot(driver, "AddProductToCompareList");

        // Assertion
        Assert.assertEquals(actualProductAdded , "Nike Floral Roshe Customized Running Shoes");
    }
}
