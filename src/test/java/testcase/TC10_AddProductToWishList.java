package testcase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static util.Utility.captureScreenshot;
public class TC10_AddProductToWishList extends TestBase {
    String password = "123456";
    String actualProductAdded;
    @Test(priority = 1, description = "Add product to shopping cart")
    public void addProductToWishList(){
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory();
        new P06_SubCategoryShoesPage(driver).addThirdProductToWishList();

        new P01_HomePage(driver).clickOnWishList();
        //actual product name which user add it to wishlist
        actualProductAdded = new P08_ShoppingCartPage(driver).productDisplayedAtCart();

        // TODO: capture screenshot
        captureScreenshot(driver, "AddProductToWishList");

        Assert.assertEquals(actualProductAdded, "Nike SB Zoom Stefan Janoski \"Medium Mint\"");
    }
}
