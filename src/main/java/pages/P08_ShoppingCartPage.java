package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_ShoppingCartPage {
    WebDriver driver;

    public P08_ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By shoppingCartBtnPage = By.xpath("//span[@class='cart-label']");
    private final By deleteItemFromShoppingCart = By.xpath("(//button[@type='button'])[2]");
    private final By termsAndConditionCheckbox = By.id("termsofservice");
    private final By checkOutBtn = By.id("checkout");
    public P08_ShoppingCartPage clickOnShoppingCartBtn() {
        driver.findElement(this.shoppingCartBtnPage).click();
        return this;
    }

    public P08_ShoppingCartPage deleteItemFromShoppingCart() {
        driver.findElement(this.deleteItemFromShoppingCart).click();
        return this;
    }

    public P08_ShoppingCartPage clickOnTermsAndConditionCheckbox(){
        driver.findElement(this.termsAndConditionCheckbox).click();
        return this;
    }

    public P08_ShoppingCartPage clickOnCheckoutBtn(){
        driver.findElement(this.checkOutBtn).click();
        return this;
    }

}