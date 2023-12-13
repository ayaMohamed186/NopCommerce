package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P11_CheckoutPaymentMethodPage {
    WebDriver driver;
    public P11_CheckoutPaymentMethodPage(WebDriver driver){
        this.driver=driver;
    }

    private final By creditOption = By.id("paymentmethod_1");
    private final By continueAtPaymentMethod = By.xpath("(//button[@type='button'])[11]");

    public P11_CheckoutPaymentMethodPage selectCreditPaymentMethod(){
        driver.findElement(this.creditOption).click();
        return this;
    }

    public P11_CheckoutPaymentMethodPage clickOnContinueAtPaymentMethod(){
        driver.findElement(this.continueAtPaymentMethod).click();
        return this;
    }
}
