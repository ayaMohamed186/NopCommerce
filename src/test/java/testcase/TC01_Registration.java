package testcase;

import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P02_RegistrationPage;

import static util.Utility.generateRandomInt;

public class TC01_Registration extends TestBase {
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    static String tempMail = faker.internet().emailAddress();
//     static String mail;
//    {
//        mail = tempMail;
//    }
    String companyName = "test";
    String password = "123456";
    String confirmPassword = "123456";
    int day = generateRandomInt(28);
    int month = generateRandomInt(12);
    int year = generateRandomInt(16);

    @Test(priority = 1, description = "Register new user with valid data ")
    public void registerNewUserWithValidData_P() throws InterruptedException
    { // p refer to positive scenario
        System.out.println("User email is : "+tempMail);
        new P01_HomePage(driver).clickRegisterBtn();
        new P02_RegistrationPage(driver).chooseGender().fillFirstName(firstName).fillLastName(lastName).selectDay(day).selectMonth(month).selectYear(year).
                fillEmailInputField(tempMail).fillPasswordField(password).fillConfirmPassword(confirmPassword).clickRegisterBtn();
        Thread.sleep(3000);
    }

    @Test(priority = 2 , description = "Register with duplicate exist mail")
    public void registerWithDuplicateMail_N() throws InterruptedException {
        tempMail = TC01_Registration.tempMail;
        new P01_HomePage(driver).clickRegisterBtn();
        new P02_RegistrationPage(driver).chooseGender().fillFirstName(firstName).fillLastName(lastName).selectDay(day).selectMonth(month).selectYear(year).
                fillEmailInputField(tempMail).fillPasswordField(password).fillConfirmPassword(confirmPassword).clickRegisterBtn();
        Thread.sleep(2000);
    }
    @Test(priority = 3 , description = "Register with password doesn't match with confirm password")
    public void registerWithPasswordNotMatchConfirmPassword_N() throws InterruptedException {
        String confirmPassword = "123";
        new P01_HomePage(driver).clickRegisterBtn();
        new P02_RegistrationPage(driver).chooseGender().fillFirstName(firstName).fillLastName(lastName).selectDay(day).selectMonth(month).selectYear(year).
                fillEmailInputField(tempMail).fillPasswordField(password).fillConfirmPassword(confirmPassword).clickRegisterBtn();
        Thread.sleep(2000);

    }

}