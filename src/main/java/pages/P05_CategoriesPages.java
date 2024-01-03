package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static pages.PageBase.shortWait;
import static util.Utility.generateRandomInt;

public class P05_CategoriesPages {
    WebDriver driver;

    public P05_CategoriesPages(WebDriver driver) {
        this.driver = driver;
    }

    private final By homePageCategories = By.xpath("(//div[@class='header-menu']/ul/li)[" + generateRandomInt(3) + "]");

    public P05_CategoriesPages hoverOnRandomCategory() {
        shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(this.homePageCategories));
        WebElement homePageCategories = driver.findElement(this.homePageCategories);
        Actions hover = new Actions(driver);
        hover.moveToElement(homePageCategories).perform();
        shortWait(driver).until(ExpectedConditions.visibilityOf(homePageCategories));
        return this;
    }
}
