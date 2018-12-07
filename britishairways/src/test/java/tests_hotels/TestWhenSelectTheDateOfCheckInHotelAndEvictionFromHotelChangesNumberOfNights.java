package tests_hotels;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

public class TestWhenSelectTheDateOfCheckInHotelAndEvictionFromHotelChangesNumberOfNights {
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
    public void whenSelectTheDateOfCheckInHotelAndEvictionFromHotelChangesNumberOfNights() {
        mainPage.clickButCon();
        mainPage.clickRadioButtonHotels();
        mainPage.clickInputCheckIn();
        mainPage.clickDateCheckIn();
        mainPage.clickInputCheckOut();
        mainPage.clickDateCheckOut(2);
        Assert.assertEquals(mainPage.getCountNights(),"2");
    }
    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
