package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class TestCheckInpPassenger {
    public static WebDriver driver;
    public static MainPage mainPage;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        driver.get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void checkInMoreThanNinePassengers() {
        mainPage.setInputTo("Moscow, Russia, DME, Domodedovo");
        mainPage.clickCheckBoxOneWay();
        mainPage.setInputAdults();
        mainPage.setInputTeens();
        mainPage.setInputChildren();
        mainPage.clickSearchButton();
        String expectedError = "The total number of adults, young adults and children must not exceed 9. If you are booking a group of 20 people or less, you can make separate bookings on ba.com up to your total number. Find out about making a booking for more than 9 people.";
        Assert.assertEquals(mainPage.getError(), expectedError);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
