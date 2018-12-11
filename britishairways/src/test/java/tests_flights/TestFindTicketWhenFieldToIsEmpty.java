package tests_flights;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageFlights;

public class TestFindTicketWhenFieldToIsEmpty {
    private PageFlights pageFlights = new PageFlights();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void findTicketWhenFieldToIsEmpty() {
        pageFlights.clickButCon();
        pageFlights.clearInputTo();
        pageFlights.clickRadioButtonOneWay();
        pageFlights.clickButtonSearch();
        String expectedError = "Please add the destination you're travelling 'To'.";
        Assert.assertEquals(pageFlights.getError(), expectedError);
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
