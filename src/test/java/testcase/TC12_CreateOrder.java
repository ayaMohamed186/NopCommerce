package testcase;

import com.github.javafaker.CreditCardType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import static util.Utility.captureScreenshot;

public class TC12_CreateOrder extends TestBase {
    String password = "123456";
    String city = "test city";
    String address = "test address";
    String zipcode = "1234";
    String phone = "123456789";
    String cardHolderName = "ayatest";
    String cardCode = "123";
    String CreditCardNumberGenerated = faker.finance().creditCard(CreditCardType.VISA);

    @Test(priority = 1, description = "Create order with full cycle")
    public void createOrder() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory();
        new P06_SubCategoryShoesPage(driver).addFirstProductToCartProductPage();
        new P07_ProductPage(driver).selectProductSize(1).addFirstProductToCart();
        new P08_ShoppingCartPage(driver).clickOnShoppingCartBtn().clickOnTermsAndConditionCheckbox().clickOnCheckoutBtn();
        new P10_CheckoutBillingAddressPage(driver).selectCheckoutCountryDropDown(4).fillCityInputField(city).
                fillAddressInputField(address).fillZipCodeInputField(zipcode).fillPhoneInputField(phone).
                clickOnContinueAtBillingAddressPage();
        new P11_CheckoutShippingMethodPage(driver).selectGroundShippingMethod().clickOnContinueBtnAtShippingMethod();
        new P12_CheckoutPaymentMethodPage(driver).selectCreditPaymentMethod().clickOnContinueAtPaymentMethod();
        new P13_PaymentInformationPage(driver).fillCardHolderName(cardHolderName).fillCreditCardNumberField(CreditCardNumberGenerated).
                selectExpireYear(2).fillCardCode(cardCode).clickOnContinueAtPaymentInfoSec();
        new P14_ConfirmOrderPage(driver).clickOnConfirmOrderBtn();


        new P14_ConfirmOrderPage(driver).waitUntilSuccessMagDisplayed();
        // TODO: capture screenshot
        captureScreenshot(driver, "SuccessOrder");

        //Assertion
        Assert.assertTrue(new P14_ConfirmOrderPage(driver).validateIfSuccessOrder());

    }
}
