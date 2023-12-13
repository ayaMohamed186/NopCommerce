package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P10_CheckoutShippingMethodPage {
    WebDriver driver;
    public P10_CheckoutShippingMethodPage(WebDriver driver){
        this.driver=driver;
    }

    private final By groundShippingMethod = By.id("shippingoption_0");
    private final By continueAtShippingMethodPage = By.xpath("(//button[@type='button'])[10]");

    public P10_CheckoutShippingMethodPage selectGroundShippingMethod(){
        driver.findElement(this.groundShippingMethod).click();
        return this;
    }
    public P10_CheckoutShippingMethodPage clickOnContinueBtnAtShippingMethod(){
        driver.findElement(this.continueAtShippingMethodPage).click();
        return this;
    }
}
