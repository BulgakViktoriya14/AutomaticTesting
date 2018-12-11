package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class MainPage {
    WebDriver driver;

    public MainPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }
}
