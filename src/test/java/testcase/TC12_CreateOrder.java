package testcase;

import com.github.javafaker.CreditCardType;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.*;

public class TC12_CreateOrder extends TestBase{
    String password = "123456";
    String city = "test city" ;
    String address = "test address";
    String zipcode = "1234";
    String phone = "123456789";
    String cardHolderName = "ayatest";
    String cardCode = "123";
    String CreditCardNumberGenerated = faker.finance().creditCard(CreditCardType.VISA);

    @Test(priority = 1,description = "Create order with full cycle")
    public void createOrder() throws InterruptedException {
        new P01_HomePage(driver).clickLoginBtn();
        new P03_LoginPage(driver).fillEmail(TC01_Registration.tempMail).fillPassword(password).clickLoginButton();
        new P06_SubCategoryShoesPage(driver).hoverOnApperalCategory().clickOnShoesSubCategory().addFirstProductToCartProductPage();
        new P07_ProductPage(driver).selectProductSize(1).addFirstProductToCart();
        Thread.sleep(4000);

        new P08_ShoppingCartPage(driver).clickOnShoppingCartBtn().clickOnTermsAndConditionCheckbox().clickOnCheckoutBtn();

        new P09_CheckoutBillingAddressPage(driver).selectCheckoutCountryDropDown(5).fillCityInputField(city).
                fillAddressInputField(address).fillZipCodeInputField(zipcode).fillPhoneInputField(phone).
                clickOnContinueAtBillingAddressPage();

        new P10_CheckoutShippingMethodPage(driver).selectGroundShippingMethod().clickOnContinueBtnAtShippingMethod();

        new P11_CheckoutPaymentMethodPage(driver).selectCreditPaymentMethod().clickOnContinueAtPaymentMethod();

        new P12_PaymentInformationPage(driver).fillCardHolderName(cardHolderName).fillCreditCardNumberField(CreditCardNumberGenerated).
                selectExpireYear(2).fillCardCode(cardCode).clickOnContinueAtPaymentInfoSec();

        new P13_ConfirmOrderPage(driver).clickOnConfirmOrderBtn();

        Thread.sleep(4000);



    }
}
