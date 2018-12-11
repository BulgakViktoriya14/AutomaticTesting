package tests_hotels;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageHotels;

public class TestChildMustBeAge {
    private PageHotels pageHotels = new PageHotels();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void childMustBeAge() {
        pageHotels.clickButtonContinue();
        pageHotels.clickRadioButtonHotels();
        pageHotels.setInputDestination("Moscow, Russia, DME, Domodedovo");
        pageHotels.setInputChildrenInRoom("1");
        pageHotels.clickInputCheckIn();
        pageHotels.clickDateCheckIn();
        pageHotels.clickInputCheckOut();
        pageHotels.clickDateCheckOut(1);
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
