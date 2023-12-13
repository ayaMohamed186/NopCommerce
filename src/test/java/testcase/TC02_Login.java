package testcase;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;

import static testcase.TC01_Registration.tempMail;

public class TC02_Login extends TestBase{
    String password="123456";
    String email = "test@test.com" ;
    @Test(priority = 1 , description = " Login with register user data " )
    public void loginWithRegisteredUser_P() throws InterruptedException {
        System.out.println("USer email is : "+TC01_Registration.tempMail);
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(tempMail).fillPassword(password).clickLoginButton();
        Thread.sleep(2000);
    }

    @Test(priority = 2,description = "Check Login Functionality with Valid Email and Invalid Password")
    public void loginWithValidEmailAndWrongPassword_N(){
        password="789";
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(tempMail).fillPassword(password).clickLoginButton();
    }
    @Test(priority = 3,description = "Check Login Functionality with Invalid Email and Valid Password")
    public void loginWithValidPasswordAndInvalidMail_N(){
        password="123456";
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(email).fillPassword(password).clickLoginButton();
    }
    @Test(priority = 4,description = "Check Login Functionality with Invalid Email and Invalid Password")
    public void loginWithInvalidCredentials_N() {
        password = "789";
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(email).fillPassword(password).clickLoginButton();
    }
}
