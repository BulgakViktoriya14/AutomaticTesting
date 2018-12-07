package tests_flights;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;
import org.junit.Assert;

public class TestCheckInMoreThanNinePassengers {
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
        mainPage.clearInputTo();
        mainPage.setInputTo("Moscow, Russia, DME, Domodedovo");
        mainPage.clickRadioButtonOneWay();
        mainPage.setInputAdults("5");
        mainPage.setInputTeens("4");
        mainPage.setInputChildren("3");
        mainPage.clickButtonSearch();
        String expectedError = "The total number of adults, young adults and children must not exceed 9. If you are booking a group of 20 people or less, you can make separate bookings on ba.com up to your total number. Find out about making a booking for more than 9 people.";
        Assert.assertEquals(mainPage.getError(), expectedError);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
