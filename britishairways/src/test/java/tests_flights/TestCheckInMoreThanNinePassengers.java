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
        pageFlights.clickButCon();
        pageFlights.clearInputTo();
        pageFlights.setInputTo("Moscow, Russia, DME, Domodedovo");
        pageFlights.clickRadioButtonOneWay();
        pageFlights.setInputAdults("5");
        pageFlights.setInputTeens("4");
        pageFlights.setInputChildren("3");
        pageFlights.clickButtonSearch();
        String expectedError = "The total number of adults, young adults and children must not exceed 9. If you are booking a group of 20 people or less, you can make separate bookings on ba.com up to your total number. Find out about making a booking for more than 9 people.";
        Assert.assertEquals(pageFlights.getError(), expectedError);
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
