package tests_flights;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class TestPerAdultCanChooseOneBaby {
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
        mainPage.setInputTo("Moscow, Russia, DME, Domodedovo");
        mainPage.clickRadioButtonOneWay();
        mainPage.setInputAdults("1");
        mainPage.setInputInfants("2");
        mainPage.clickButtonSearch();
        Assert.assertEquals(mainPage.getError(),"For safety reasons onboard, the number of infants travelling cannot exceed the number of adults.");
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
