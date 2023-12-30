package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P04_ForgetPasswordPage;

import static util.Utility.captureScreenshot;

public class TC03_ResetPassword extends TestBase {

    @Test(priority = 1, description = "Reset User Password")
    public void
    resetPasswordFunction() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P04_ForgetPasswordPage(driver).clickOnforgetPasswordLink().fillMailForForgetPassword(TC01_Registration.tempMail).
                clickOnRecoverBtn();
        Thread.sleep(1500);

        // TODO: capture screenshot
        captureScreenshot(driver, "ResetPassword");

        //Assertion
        Assert.assertTrue(new P04_ForgetPasswordPage(driver).verifyConfirmMsgDisplayed());
    }
}
