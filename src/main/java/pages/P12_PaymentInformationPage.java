package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.shortWait;

public class P12_PaymentInformationPage {
    WebDriver driver;
    public P12_PaymentInformationPage(WebDriver driver){
        this.driver=driver;
    }
    private final By cardHolderName = By.xpath("//input[@id='CardholderName']");
    private final By cardNumberEle = By.xpath("//input[@id='CardNumber']");
    private final By cardExpireYear = By.xpath("//select[@id='ExpireYear']");
    private final By cardCodeEle = By.xpath("//input[@id='CardCode']");
    private final By continuePaymentInfoSection = By.xpath("(//button[@type='button'])[12]");


    public P12_PaymentInformationPage fillCardHolderName(String holderName){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardHolderName));
        driver.findElement(this.cardHolderName).sendKeys(holderName);
        return this;
    }
    public P12_PaymentInformationPage fillCreditCardNumberField(String creditNumber){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardNumberEle));
        driver.findElement(this.cardNumberEle).sendKeys(creditNumber);
        return this;
    }

    public P12_PaymentInformationPage selectExpireYear(int index){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardExpireYear));
        WebElement cardExpireYear = driver.findElement(this.cardExpireYear);
        Select cardExpireY =new Select(cardExpireYear);
        cardExpireY.selectByIndex(index);
        return this;
    }
    public P12_PaymentInformationPage fillCardCode(String cardCode){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.cardCodeEle));
        driver.findElement(this.cardCodeEle).sendKeys(cardCode);
        return this;
    }

    public P12_PaymentInformationPage clickOnContinueAtPaymentInfoSec(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continuePaymentInfoSection));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continuePaymentInfoSection).click();
        return this;
    }

}
