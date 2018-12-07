package tests_hotels;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class TestChildMustBeAge {
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
    public void childMustBeAge() {
        mainPage.clickButCon();
        mainPage.clickRadioButtonHotels();
        mainPage.setInputDestination("Moscow, Russia, DME, Domodedovo");
        mainPage.setInputChildrenInRoom("1");
        mainPage.clickInputCheckIn();
        mainPage.clickDateCheckIn();
        mainPage.clickInputCheckOut();
        mainPage.clickDateCheckOut(1);
        mainPage.clickButtonSearchHotels();
        Assert.assertEquals(mainPage.getError(),"Please enter all child ages");
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
