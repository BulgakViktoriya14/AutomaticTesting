import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WebDriverTest {
    @Test
    public void findTicketWhenFieldToIsEmpty() {
        System.setProperty("webdriver.chrome.driver", "D://selenium/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.britishairways.com/en-by/flights-and-holidays/flights");
        WebElement buttonContinue = driver.findElement(By.name("Continue"));
        buttonContinue.click();
        WebElement buttonFindFlights = driver.findElement(By.id("flightSearchButton"));
        buttonFindFlights.click();
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".errorList>li")));
        String realError = result.getText();
        String expectedError = "Please add the destination you're travelling 'To'.";
        driver.quit();
        assertEquals(realError,expectedError);
    }
}
