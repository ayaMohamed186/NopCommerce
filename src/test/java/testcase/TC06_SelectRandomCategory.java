package testcase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;
import pages.P05_CategoriesPages;

import static util.Utility.captureScreenshot;

public class TC06_SelectRandomCategory extends TestBase{
    String password = "123456";
    @Test(priority = 1 , description = "Select Random Category")
    public void selectRandomCategory() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P05_CategoriesPages(driver).hoverOnRandomCategory();
        Thread.sleep(1500);

        // TODO: capture screenshot
        captureScreenshot(driver, "SelectedRandomCategory");
    }
}
