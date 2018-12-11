package tests_flights;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageFlights;

public class TestIfSelectOneWayThatFieldReturnDateIsNotActive {
    private PageFlights pageFlights = new PageFlights();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void checkInMoreThanNinePassengers() {
        pageFlights.clickButtonContinue();
        pageFlights.clickRadioButtonOneWay();
        Assert.assertFalse(pageFlights.inputReturnDateIsEnabled());
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
