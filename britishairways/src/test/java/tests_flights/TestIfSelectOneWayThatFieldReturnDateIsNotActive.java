package tests_flights;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class TestIfSelectOneWayThatFieldReturnDateIsNotActive {
    private static WebDriver driver;
    private static MainPage mainPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void checkInMoreThanNinePassengers() {
        mainPage.clickButCon();
        mainPage.clickRadioButtonOneWay();
        Assert.assertEquals(mainPage.inputReturnDateIsEnabled(), false);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
