package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class P04_ForgetPasswordPage{
    WebDriver driver;
    public P04_ForgetPasswordPage(WebDriver driver){
        this.driver=driver;
    }

    private final By forgetPasswordLink = By.xpath("//a[@href='/passwordrecovery']");
    private final By mailInputFieldForForgePassword = By.id("Email");
    private final By recoverBtnAtForgetPage = By.xpath("//button[@name='send-email']");

    public P04_ForgetPasswordPage clickOnforgetPasswordLink(){
        driver.findElement(this.forgetPasswordLink).click();
        return this;
    }
    public P04_ForgetPasswordPage fillMailForForgetPassword(String mail){
        driver.findElement(this.mailInputFieldForForgePassword).sendKeys(mail);
        return this;
    }

    public P04_ForgetPasswordPage clickOnRecoverBtn(){
        driver.findElement(this.recoverBtnAtForgetPage).click();
        return this;
    }
}
