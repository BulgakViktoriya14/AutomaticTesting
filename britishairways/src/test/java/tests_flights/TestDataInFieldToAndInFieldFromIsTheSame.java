package tests_flights;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageFlights;

public class TestDataInFieldToAndInFieldFromIsTheSame {
    private PageFlights pageFlights = new PageFlights();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void dataInFieldToAndInFieldFromIsTheSame() {
        pageFlights.clickButtonContinue();
        pageFlights.clearInputTo();
        pageFlights.setInputTo("New York, USA, NYC, New York (All Airports)");
        pageFlights.clickRadioButtonOneWay();
        pageFlights.clickButtonSearch();
        Assert.assertEquals(pageFlights.getError(),"Your departure and destination points appear to be the same. Please check all your requirements are correct and try again.");
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
