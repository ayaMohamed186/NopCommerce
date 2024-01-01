package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.shortWait;

public class P10_CheckoutBillingAddressPage {
    WebDriver driver;

    public P10_CheckoutBillingAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutCountryDropDown = By.xpath("//select[@id='BillingNewAddress_CountryId']");
    private final By cityInputField = By.id("BillingNewAddress_City");
    private final By address1InputField = By.id("BillingNewAddress_Address1");
    private final By zipCodeInputField = By.id("BillingNewAddress_ZipPostalCode");
    private final By phoneInputField = By.id("BillingNewAddress_PhoneNumber");
    private final By continueBillingAddressDetailsBtn = By.xpath("(//button[@name='save'])[1]");


    public P10_CheckoutBillingAddressPage selectCheckoutCountryDropDown(int index) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.checkoutCountryDropDown));
        WebElement checkoutCountryDropDown = driver.findElement(this.checkoutCountryDropDown);
        Select countryDD = new Select(checkoutCountryDropDown);
        countryDD.selectByIndex(index);
        return this;
    }

    public P10_CheckoutBillingAddressPage fillCityInputField(String City) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cityInputField));
        driver.findElement(this.cityInputField).sendKeys(City);
        return this;
    }

    public P10_CheckoutBillingAddressPage fillAddressInputField(String Address) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.address1InputField));
        driver.findElement(this.address1InputField).sendKeys(Address);
        return this;
    }

    public P10_CheckoutBillingAddressPage fillZipCodeInputField(String ZipCode) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.zipCodeInputField));
        driver.findElement(this.zipCodeInputField).sendKeys(ZipCode);
        return this;
    }

    public P10_CheckoutBillingAddressPage fillPhoneInputField(String phone) {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.phoneInputField));
        driver.findElement(this.phoneInputField).sendKeys(phone);
        return this;
    }

    public P10_CheckoutBillingAddressPage clickOnContinueAtBillingAddressPage() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueBillingAddressDetailsBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueBillingAddressDetailsBtn).click();
        return this;
    }

}
