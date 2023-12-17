package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P09_CheckoutBillingAddressPage {
    WebDriver driver;

    public P09_CheckoutBillingAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutCountryDropDown = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private final By cityInputField = By.id("BillingNewAddress_City");
    private final By address1InputField = By.id("BillingNewAddress_Address1");
    private final By zipCodeInputField =  By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneInputField = By.id("BillingNewAddress_PhoneNumber");
    private final By continueBillingAddressDetailsBtn = By.xpath("(//button[@name='save'])[1]");


    public P09_CheckoutBillingAddressPage selectCheckoutCountryDropDown(int index){
        WebElement checkoutCountryDropDown = driver.findElement(this.checkoutCountryDropDown);
        Select countryDD =new Select(checkoutCountryDropDown);
        countryDD.selectByIndex(index);
        return this;
    }
    public P09_CheckoutBillingAddressPage fillCityInputField(String City){
        driver.findElement(this.cityInputField).sendKeys(City);
        return this;
    }
    public P09_CheckoutBillingAddressPage fillAddressInputField(String Address){
        driver.findElement(this.address1InputField).sendKeys(Address);
        return this;
    }
    public P09_CheckoutBillingAddressPage fillZipCodeInputField(String ZipCode){
        driver.findElement(this.zipCodeInputField).sendKeys(ZipCode);
        return this;
    }
    public P09_CheckoutBillingAddressPage fillPhoneInputField(String phone){
        driver.findElement(this.phoneInputField).sendKeys(phone);
        return this;
    }

    public P09_CheckoutBillingAddressPage clickOnContinueAtBillingAddressPage(){
        driver.findElement(this.continueBillingAddressDetailsBtn).click();
        return this;
    }

}
