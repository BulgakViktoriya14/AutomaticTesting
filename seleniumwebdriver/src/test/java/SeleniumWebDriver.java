import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumWebDriver {
    @Test
    public void findTicketWhenFieldToIsEmpty() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.britishairways.com/ru-us/flights-and-holidays/flights");
        driver.findElement(By.id("planTripFlightDestination")).clear();
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector(".styledRadioButton>input"))).click().build().perform();
        driver.findElement(By.id("flightSearchButton")).click();
        String realError = driver.findElement(By.cssSelector(".errorList>li")).getText();
        String expectedError = "Please add the destination you're travelling 'To'.";
        driver.quit();
        assertEquals(realError,expectedError);
    }
}
