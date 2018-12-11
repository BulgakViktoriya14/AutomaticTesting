package tests_flights;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageFlights;

public class TestPerAdultCanChooseOneBaby {
    private PageFlights pageFlights = new PageFlights();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void checkInMoreThanNinePassengers() {
        pageFlights.clickButCon();
        pageFlights.setInputTo("Moscow, Russia, DME, Domodedovo");
        pageFlights.clickRadioButtonOneWay();
        pageFlights.setInputAdults("1");
        pageFlights.setInputInfants("2");
        pageFlights.clickButtonSearch();
        Assert.assertEquals(pageFlights.getError(),"For safety reasons onboard, the number of infants travelling cannot exceed the number of adults.");
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
