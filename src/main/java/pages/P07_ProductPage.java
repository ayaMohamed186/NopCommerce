package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class P07_ProductPage {
    WebDriver driver;
    public P07_ProductPage(WebDriver driver){
        this.driver = driver;
    }

    private final By firstProductSize = By.xpath("//select[@data-attr='9']");
    private final By firstProductAddToCartBTN = By.xpath("//button[@id='add-to-cart-button-25']");
    public P07_ProductPage selectProductSize(int index){
        WebElement productSize = driver.findElement(this.firstProductSize);
        Select productS=new Select(productSize);
        productS.selectByIndex(index);
        return this;
    }
    public P07_ProductPage addFirstProductToCart(){
        driver.findElement(this.firstProductAddToCartBTN).click();
        return this;
    }




}