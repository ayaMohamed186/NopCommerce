package testcase;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P06_SubCategoryShoesPage;

public class TC08_SelectDifferentTags extends TestBase{
    String password = "123456";

    @Test(priority = 1 , description = "Select different tags ")
    public void selectDifferentTags() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().selectRandomSubCategory();
        Thread.sleep(1500);
    }
}
