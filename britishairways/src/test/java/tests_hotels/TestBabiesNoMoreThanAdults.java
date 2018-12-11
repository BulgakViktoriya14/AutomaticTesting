package tests_hotels;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageHotels;

public class TestBabiesNoMoreThanAdults {
    private PageHotels pageHotels = new PageHotels();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void checkBabiesNoMoreThanAdults() {
        pageHotels.clickButtonContinue();
        pageHotels.clickRadioButtonHotels();
        pageHotels.setInputAdultsInRoom("3");
        Assert.assertEquals(pageHotels.foundCountInputInfantsInRoom(),4);
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
