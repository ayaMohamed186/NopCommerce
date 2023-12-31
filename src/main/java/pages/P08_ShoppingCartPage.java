package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P08_ShoppingCartPage {
    WebDriver driver;

    public P08_ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By shoppingCartBtnPage = By.xpath("//span[@class='cart-label']");
    private final By deleteItemFromShoppingCart = By.xpath("(//button[@type='button'])[2]");
    private final By termsAndConditionCheckbox = By.id("termsofservice");
    private final By checkOutBtn = By.id("checkout");
    private final By productAddedToCart = By.xpath("//div[@class='product-name']/h1");
    private final By productDisplayedAtCart = By.xpath("//a[@class='product-name']");
    public P08_ShoppingCartPage clickOnShoppingCartBtn() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.shoppingCartBtnPage));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.shoppingCartBtnPage).click();
        return this;
    }

    public P08_ShoppingCartPage deleteItemFromShoppingCart() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.deleteItemFromShoppingCart));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.deleteItemFromShoppingCart).click();
        return this;
    }

    public P08_ShoppingCartPage clickOnTermsAndConditionCheckbox(){
        try {
            longWait(driver).until(ExpectedConditions.elementToBeClickable(this.termsAndConditionCheckbox));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.termsAndConditionCheckbox).click();
        return this;
    }

    public P08_ShoppingCartPage clickOnCheckoutBtn(){
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.checkOutBtn));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.checkOutBtn).click();
        return this;
    }
    public String productAddedToCart(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productAddedToCart));
        return driver.findElement(this.productAddedToCart).getText();
    }
    public String productDisplayedAtCart(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productDisplayedAtCart));
        return driver.findElement(this.productDisplayedAtCart).getText();
    }

    public P08_ShoppingCartPage waitUntilProductDisplayed(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productDisplayedAtCart));
        return this;
    }
}