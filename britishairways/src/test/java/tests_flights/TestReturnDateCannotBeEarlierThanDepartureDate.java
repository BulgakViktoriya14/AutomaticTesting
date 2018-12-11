package tests_flights;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageFlights;

public class TestReturnDateCannotBeEarlierThanDepartureDate {
    private PageFlights pageFlights = new PageFlights();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void returnDateCannotBeEarlierThanDepartureDate() {
        pageFlights.clickButtonContinue();
        pageFlights.clickInputReturnDate();
        pageFlights.clickDateReturn();
        pageFlights.clickInputDepDate();
        pageFlights.clickDateDep(2);
        Assert.assertEquals(pageFlights.getDateDep(),pageFlights.getDateReturn());
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
