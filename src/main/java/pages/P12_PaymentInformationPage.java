package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class P12_PaymentInformationPage {
    WebDriver driver;
    public P12_PaymentInformationPage(WebDriver driver){
        this.driver=driver;
    }
    private final By cardHolderName = By.id("CardholderName");
    private final By cardNumberEle = By.id("CardNumber");
    private final By cardExpireYear = By.id("ExpireYear");
    private final By cardCodeEle = By.id("CardCode");
    private final By continuePaymentInfoSection = By.xpath("(//button[@type='button'])[12]");


    public P12_PaymentInformationPage fillCardHolderName(String holderName){
        driver.findElement(this.cardHolderName).sendKeys(holderName);
        return this;
    }
    public P12_PaymentInformationPage fillCreditCardNumberField(String creditNumber){
        driver.findElement(this.cardNumberEle).sendKeys(creditNumber);
        return this;
    }

    public P12_PaymentInformationPage selectExpireYear(int index){
        WebElement cardExpireYear = driver.findElement(this.cardExpireYear);
        Select cardExpireY =new Select(cardExpireYear);
        cardExpireY.selectByIndex(index);
        return this;
    }
    public P12_PaymentInformationPage fillCardCode(String cardCode){
        driver.findElement(this.cardCodeEle).sendKeys(cardCode);
        return this;
    }

    public P12_PaymentInformationPage clickOnContinueAtPaymentInfoSec(){
        driver.findElement(this.continuePaymentInfoSection).click();
        return this;
    }

}
