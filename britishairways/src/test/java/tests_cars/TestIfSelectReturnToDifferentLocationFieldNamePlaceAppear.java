package tests_cars;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.PageCars;

public class TestIfSelectReturnToDifferentLocationFieldNamePlaceAppear {
    private PageCars pageCars = new PageCars();

    @BeforeClass
    public static void openDriver() {
        Driver.getDriver().get("https://www.britishairways.com/en-us/flights-and-holidays/flights");
    }
    @Test
    public void checkInMoreThanNinePassengers() {
        pageCars.clickButCon();
        pageCars.clickRadioButtonCars();
        pageCars.clickCheckBoxReturning();
        Assert.assertEquals(pageCars.divForNameLocationIsDisabled(),true);
    }
    @AfterClass
    public static void closeDriver() {
        Driver.closeDriver();
    }
}
