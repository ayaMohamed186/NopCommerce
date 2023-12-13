package testcase;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;

public class TC04_SearchForProduct extends TestBase{

    String password = "123456";
    String searchItem = "notebook";
    @Test(priority = 1 , description = "search for any product")
    public void searchForProduct() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P01_HomePage(driver).fillDataInSearchField(searchItem).clickOnSearchBtn();
        Thread.sleep(2000);
    }
}
