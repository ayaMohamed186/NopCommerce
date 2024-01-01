package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static util.Utility.captureScreenshot;

public class TC09_AddProductToShoppingCart extends TestBase {
    String password = "123456";
    String productAddedToCartStr;
    String actualProductAdded;
    @Test(priority = 1, description = "Add product to shopping cart")
    public void addProductToShoppingCart(){
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory();
        new P06_SubCategoryShoesPage(driver).addFirstProductToCartProductPage();
        productAddedToCartStr = new P08_ShoppingCartPage(driver).productAddedToCart();
        new P07_ProductPage(driver).selectProductSize(1).addFirstProductToCart();
        new P08_ShoppingCartPage(driver).clickOnShoppingCartBtn();

        actualProductAdded = new P08_ShoppingCartPage(driver).productDisplayedAtCart();
        // TODO: capture screenshot
        captureScreenshot(driver, "AddProductToCart");

        //Assertion
        Assert.assertEquals(actualProductAdded, productAddedToCartStr);

        new P08_ShoppingCartPage(driver).deleteItemFromShoppingCart();
        //Thread.sleep(1000);

    }
}
