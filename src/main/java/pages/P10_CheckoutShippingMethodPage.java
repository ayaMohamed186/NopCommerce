package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P10_CheckoutShippingMethodPage {
    WebDriver driver;

    public P10_CheckoutShippingMethodPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By groundShippingMethod = By.xpath("//input[@id='shippingoption_0']");
    private final By continueAtShippingMethodPage = By.xpath("(//button[@type='button'])[10]");

    public P10_CheckoutShippingMethodPage selectGroundShippingMethod() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.groundShippingMethod));
        driver.findElement(this.groundShippingMethod).click();
        return this;
    }

    public P10_CheckoutShippingMethodPage clickOnContinueBtnAtShippingMethod() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueAtShippingMethodPage));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueAtShippingMethodPage).click();
        return this;
    }
}
