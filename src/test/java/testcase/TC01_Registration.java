package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegistrationPage;
import util.Utility;

import static util.Utility.captureScreenshot;
import static util.Utility.generateRandomInt;

public class TC01_Registration extends TestBase {
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    static String tempMail = faker.internet().emailAddress();
    String password = "123456";
    String confirmPassword = "123456";
    int day = generateRandomInt(28);
    int month = generateRandomInt(12);
    int year = generateRandomInt(16);
    String displayedRegisterMsg;
    String displayedRepeatMas;
    String unMatchPasswordMsg;

    @Test(priority = 1, description = "Register new user with valid data ")
    public void registerNewUserWithValidData_P() throws InterruptedException { // p refer to positive scenario
        System.out.println("User email is : " + tempMail);
        new P01_HomePage(driver).clickRegisterBtn();
        new P02_RegistrationPage(driver).chooseGender().fillFirstName(firstName).fillLastName(lastName).selectDay(day).selectMonth(month).selectYear(year).
                fillEmailInputField(tempMail).fillPasswordField(password).fillConfirmPassword(confirmPassword).clickRegisterBtn();
        Thread.sleep(2000);

        // TODO: capture screenshot
        captureScreenshot(driver, "P_registration");

        // TODO: assert registration successfully
        displayedRegisterMsg = new P02_RegistrationPage(driver).getDisplayedRegisterMsg();
        Assert.assertEquals(displayedRegisterMsg, "Your registration completed");
    }

    @Test(priority = 2, description = "Register with duplicate exist mail")
    public void registerWithDuplicateMail_N() throws InterruptedException {
        tempMail = TC01_Registration.tempMail;
        new P01_HomePage(driver).clickRegisterBtn();
        new P02_RegistrationPage(driver).chooseGender().fillFirstName(firstName).fillLastName(lastName).selectDay(day).selectMonth(month).selectYear(year).
                fillEmailInputField(tempMail).fillPasswordField(password).fillConfirmPassword(confirmPassword).clickRegisterBtn();
        Thread.sleep(2000);

        // TODO: capture screenshot
        captureScreenshot(driver, "Failed_registration");

        // Assertion
        displayedRepeatMas = new P02_RegistrationPage(driver).getRepeatMailMsg();
        Assert.assertEquals(displayedRepeatMas, "The specified email already exists");
    }

    @Test(priority = 3, description = "Register with password doesn't match with confirm password")
    public void registerWithPasswordNotMatchConfirmPassword_N() throws InterruptedException {
        String confirmPassword = "123";
        new P01_HomePage(driver).clickRegisterBtn();
        new P02_RegistrationPage(driver).chooseGender().fillFirstName(firstName).fillLastName(lastName).selectDay(day).selectMonth(month).selectYear(year).
                fillEmailInputField(tempMail).fillPasswordField(password).fillConfirmPassword(confirmPassword).clickRegisterBtn();
        Thread.sleep(2000);

        // TODO: capture screenshot
        captureScreenshot(driver, "Failed_registration1");
        unMatchPasswordMsg = new P02_RegistrationPage(driver).getUnMatchMsg();
        Assert.assertEquals(unMatchPasswordMsg, "The password and confirmation password do not match.");
    }
}