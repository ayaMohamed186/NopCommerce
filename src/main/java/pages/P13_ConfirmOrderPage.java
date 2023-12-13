package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P13_ConfirmOrderPage {
    WebDriver driver ;
    public P13_ConfirmOrderPage(WebDriver driver){
        this.driver = driver;
    }

    private final By continueAtConfirmOrderPage = By.xpath("(//button[@type='button'])[13]");
    public P13_ConfirmOrderPage clickOnConfirmOrderBtn(){
        driver.findElement(this.continueAtConfirmOrderPage).click();
        return this;
    }
}
