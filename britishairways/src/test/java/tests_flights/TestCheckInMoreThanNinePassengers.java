package tests_flights;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
import pages.PageFlights;

public class TestCheckInMoreThanNinePassengers {
    private PageFlights pageFlights = new PageFlights();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void checkInMoreThanNinePassengers() {
        pageFlights.clickButtonContinue();
        pageFlights.clearInputTo();
        pageFlights.setInputTo("Moscow, Russia, DME, Domodedovo");
        pageFlights.setInputAdults("5");
        pageFlights.setInputTeens("4");
        pageFlights.setInputChildren("3");
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
