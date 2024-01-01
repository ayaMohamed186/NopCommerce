package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P04_ForgetPasswordPage{
    WebDriver driver;
    public P04_ForgetPasswordPage(WebDriver driver){
        this.driver=driver;
    }

    private final By forgetPasswordLink = By.xpath("//a[@href='/passwordrecovery']");
    private final By mailInputFieldForForgePassword = By.id("Email");
    private final By recoverBtnAtForgetPage = By.xpath("//button[@name='send-email']");
    private final By confirmMageOfResetPassword = By.xpath("//p[@class='content']");

    public P04_ForgetPasswordPage clickOnforgetPasswordLink(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.forgetPasswordLink));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.forgetPasswordLink).click();
        return this;
    }
    public P04_ForgetPasswordPage fillMailForForgetPassword(String mail){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.mailInputFieldForForgePassword));
        driver.findElement(this.mailInputFieldForForgePassword).sendKeys(mail);
        return this;
    }

    public P04_ForgetPasswordPage clickOnRecoverBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.recoverBtnAtForgetPage));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.recoverBtnAtForgetPage).click();
        return this;
    }

    public boolean verifyConfirmMsgDisplayed(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.confirmMageOfResetPassword));
        String msgDisplayed = driver.findElement(this.confirmMageOfResetPassword).getText();
        return msgDisplayed.equals("Email with instructions has been sent to you.");
    }

    public P04_ForgetPasswordPage waitUntilPageLoad(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.confirmMageOfResetPassword));
        return this;
    }



}
