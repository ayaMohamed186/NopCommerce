package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P06_SubCategoryShoesPage;
import pages.P07_ProductPage;

import static util.Utility.captureScreenshot;

public class TC10_AddProductToWishList extends TestBase{

    String password = "123456";
    String actualProductAdded;

    @Test(priority = 1 , description = "Add product to shopping cart")
    public void addProductToWishList() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory();
        //Thread.sleep(1000);

        new P06_SubCategoryShoesPage(driver).addThirdProductToWishList();
        Thread.sleep(1500);

        // TODO: capture screenshot
        captureScreenshot(driver, "AddProductToWishList");

        new P01_HomePage(driver).clickOnWishList();
        //actual product name which user add it to wishlist
        actualProductAdded = new P07_ProductPage(driver).productDisplayedAtCart();

        Assert.assertEquals(actualProductAdded , "Nike SB Zoom Stefan Janoski \"Medium Mint\"");


    }
}
