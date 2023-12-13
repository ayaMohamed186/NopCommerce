package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static util.Utility.generateRandomInt;

public class P05_CategoriesPages {
    WebDriver driver;
    public P05_CategoriesPages(WebDriver driver){
        this.driver = driver;
    }

    private final By homePageCategories = By.xpath("(//div[@class='header-menu']/ul/li)["+generateRandomInt(3)+"]");
    public P05_CategoriesPages hoverOnRandomCategory(){
        WebElement homePageCategories = driver.findElement(this.homePageCategories);
        Actions hover = new Actions(driver);
        hover.moveToElement(homePageCategories).perform();
        return this;
    }
}
