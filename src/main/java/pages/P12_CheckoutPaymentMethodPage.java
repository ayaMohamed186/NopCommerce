package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P12_CheckoutPaymentMethodPage {
    WebDriver driver;
    public P12_CheckoutPaymentMethodPage(WebDriver driver){
        this.driver=driver;
    }

    private final By creditOption = By.xpath("//input[@id='paymentmethod_1']");
    private final By continueAtPaymentMethod = By.xpath("(//button[@type='button'])[11]");

    public P12_CheckoutPaymentMethodPage selectCreditPaymentMethod(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.creditOption));
        driver.findElement(this.creditOption).click();
        return this;
    }

    public P12_CheckoutPaymentMethodPage clickOnContinueAtPaymentMethod(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueAtPaymentMethod));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueAtPaymentMethod).click();
        return this;
    }
}
