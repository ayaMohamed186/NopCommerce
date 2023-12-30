package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static pages.PageBase.longWait;
import static pages.PageBase.shortWait;

public class P07_ProductPage {
    WebDriver driver;

    public P07_ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstProductSize = By.xpath("//select[@data-attr='9']");
    private final By firstProductAddToCartBTN = By.xpath("//button[@id='add-to-cart-button-25']");
    private final By productAddedToCart = By.xpath("//div[@class='product-name']/h1");
    private final By productDisplayedAtCart = By.xpath("//a[@class='product-name']");
    private final By productAddedToCompareList = By.xpath("//tr[@class='product-name']//td[2]//a");

    public P07_ProductPage selectProductSize(int index) {
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.firstProductSize));
        WebElement productSize = driver.findElement(this.firstProductSize);
        Select productS = new Select(productSize);
        productS.selectByIndex(index);
        return this;
    }

    public P07_ProductPage addFirstProductToCart() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(this.firstProductAddToCartBTN));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            System.out.println("Error happened is " + ex.getMessage());
        }
        driver.findElement(this.firstProductAddToCartBTN).click();
        return this;
    }

    public String productAddedToCart(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productAddedToCart));
        return driver.findElement(this.productAddedToCart).getText();
    }
    public String productDisplayedAtCart(){
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productDisplayedAtCart));
        return driver.findElement(this.productDisplayedAtCart).getText();
    }

    public String getProductAddedToCompareList(){
        longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.productAddedToCompareList));
        return driver.findElement(this.productAddedToCompareList).getText();
    }

}