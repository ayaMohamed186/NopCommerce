package testcase;

import com.github.javafaker.Faker;
import drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.P01_HomePage;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.setDriver;

public class TestBase {

    WebDriver driver;
    static Faker faker=new Faker();

    @Parameters("browser")

    @BeforeTest
    public void setupDriver(String browser){
       // WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();

        //driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver = DriverFactory.getNewInstance(browser);
        setDriver(driver);

        // TOOD: start website
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
        Thread.currentThread().interrupt(); // after driver close , close opened thread which open in each run
    }
}
