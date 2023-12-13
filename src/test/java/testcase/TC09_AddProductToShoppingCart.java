package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

public class TC09_AddProductToShoppingCart extends TestBase{
    String password = "123456";
    @Test(priority = 1 , description = "Add product to shopping cart")
    public void addProductToShoppingCart() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory().addFirstProductToCartProductPage();
        new P07_ProductPage(driver).selectProductSize(1).addFirstProductToCart();
        Thread.sleep(4000);
        //WebDriverWait w = new WebDriverWait(driver, 5);
        //w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='cart-label']")));

        new P08_ShoppingCartPage(driver).clickOnShoppingCartBtn();
        Thread.sleep(1000);
        new P08_ShoppingCartPage(driver).deleteItemFromShoppingCart();

        Thread.sleep(1000);
    }
}
