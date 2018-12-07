package tests_flights;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class TestFindTicketWhenFieldToIsEmpty {
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
    public void findTicketWhenFieldToIsEmpty() {
        mainPage.clickButCon();
        mainPage.clearInputTo();
        mainPage.clickRadioButtonOneWay();
        mainPage.clickButtonSearch();
        String expectedError = "Please add the destination you're travelling 'To'.";
        Assert.assertEquals(mainPage.getError(), expectedError);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
