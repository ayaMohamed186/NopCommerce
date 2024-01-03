package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P01_HomePage;
import pages.P03_LoginPage;

import static util.Utility.captureScreenshot;
import static util.Utility.generateRandomInt;

public class TC05_SwitchBetweenCurrencies extends TestBase {
    String password = "123456";
    int currencyIndex = generateRandomInt(1);
    @Test(priority = 1, description = " switch between currencies")
    public void switchBetweenCurrencies()  {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P01_HomePage(driver).chooseCurrency(currencyIndex);

        new P01_HomePage(driver).waitUntilCurrencyChange();
        // TODO: capture screenshot
        captureScreenshot(driver, "SwitchBetweenCurrency");

        //Assertion
        Assert.assertTrue(new P01_HomePage(driver).validateIfCurrencyChanged());
    }
}
