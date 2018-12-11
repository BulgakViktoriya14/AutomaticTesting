package tests_hotels;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageHotels;

public class TestWhenSelectTheDateOfCheckInHotelAndEvictionFromHotelChangesNumberOfNights {
    private PageHotels pageHotels = new PageHotels();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void whenSelectTheDateOfCheckInHotelAndEvictionFromHotelChangesNumberOfNights() {
        pageHotels.clickButtonContinue();
        pageHotels.clickRadioButtonHotels();
        pageHotels.clickInputCheckIn();
        pageHotels.clickDateCheckIn();
        pageHotels.clickInputCheckOut();
        pageHotels.clickDateCheckOut(2);
        Assert.assertEquals(pageHotels.getCountNights(),"2");
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
