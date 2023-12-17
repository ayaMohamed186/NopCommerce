package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P06_SubCategoryShoesPage;
import pages.P07_ProductPage;

public class TC10_AddProductToWishList extends TestBase{

    String password = "123456";
    @Test(priority = 1 , description = "Add product to shopping cart")
    public void addProductToWishList() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory();
        Thread.sleep(1000);
        new P06_SubCategoryShoesPage(driver).addThirdProductToWishList();
        Thread.sleep(2000);

    }
}
