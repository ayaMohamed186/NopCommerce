package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;

import static testcase.TC01_Registration.tempMail;
import static util.Utility.captureScreenshot;

public class TC02_Login extends TestBase {
    String password = "123456";
    String email = "test@test.com";
    String logoutBtnDisplayed;
    String failedMagDisplayed;
    @Test(priority = 1, description = " Login with register user data ")
    public void loginWithRegisteredUser_P() {
        System.out.println("USer email is : " + TC01_Registration.tempMail);
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(tempMail).fillPassword(password).clickLoginButton();

        new P01_HomePage(driver).waitUntilPageLoad();
        // TODO: capture screenshot
        captureScreenshot(driver, "loginSystem");

        // assertion
        logoutBtnDisplayed = new P01_HomePage(driver).getLogoutBtn();
        Assert.assertEquals(logoutBtnDisplayed, "Log out");
    }

    @Test(priority = 2, description = "Check Login Functionality with Valid Email and Invalid Password")
    public void loginWithValidEmailAndWrongPassword_N() throws InterruptedException {
        password = "789";
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(tempMail).fillPassword(password).clickLoginButton();
        Thread.sleep(2000);

        // TODO: capture screenshot
        captureScreenshot(driver, "Failed_loginSystem");

        //Assertion
        failedMagDisplayed = new P01_HomePage(driver).getFailedLoginMsg();
        Assert.assertEquals(failedMagDisplayed, "Login was unsuccessful. Please correct the errors and try again.");

    }

    @Test(priority = 3, description = "Check Login Functionality with Invalid Email and Valid Password")
    public void loginWithValidPasswordAndInvalidMail_N() throws InterruptedException {
        password = "123456";
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(email).fillPassword(password).clickLoginButton();
        Thread.sleep(2000);

        // TODO: capture screenshot
        captureScreenshot(driver, "Failed_loginSystem2");

        //Assertion
        failedMagDisplayed = new P01_HomePage(driver).getFailedLoginMsg();
        Assert.assertEquals(failedMagDisplayed, "Login was unsuccessful. Please correct the errors and try again.");

    }

    @Test(priority = 4, description = "Check Login Functionality with Invalid Email and Invalid Password")
    public void loginWithInvalidCredentials_N() throws InterruptedException {
        password = "789";
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(email).fillPassword(password).clickLoginButton();
        Thread.sleep(2000);

        // TODO: capture screenshot
        captureScreenshot(driver, "Failed_loginSystem3");

        //Assertion
        failedMagDisplayed = new P01_HomePage(driver).getFailedLoginMsg();
        Assert.assertEquals(failedMagDisplayed, "Login was unsuccessful. Please correct the errors and try again.");
    }
}
