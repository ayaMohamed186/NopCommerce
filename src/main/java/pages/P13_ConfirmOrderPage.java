package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.shortWait;

public class P13_ConfirmOrderPage {
    WebDriver driver ;
    public P13_ConfirmOrderPage(WebDriver driver){
        this.driver = driver;
    }

    private final By continueAtConfirmOrderPage = By.xpath("(//button[@type='button'])[13]");
    private final By orderSuccessConfirmMsg = By.xpath("//div[@class='title']/strong");
    public P13_ConfirmOrderPage clickOnConfirmOrderBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.continueAtConfirmOrderPage));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.continueAtConfirmOrderPage).click();
        return this;
    }

    public boolean validateIfSuccessOrder(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.orderSuccessConfirmMsg));
        return driver.findElement(this.orderSuccessConfirmMsg).getText().equals("Your order has been successfully processed!");
    }
}
