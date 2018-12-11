package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PageCars extends MainPage{
    @FindBy(id = "carRadioSelector")
    private WebElement radioButtonCars;

    @FindBy(id = "carOneWayRentalConfirm")
    private WebElement checkBoxReturning;

    @FindBy(id = "returningToDifferentLocation")
    private WebElement divForNameLocation;

    @FindBy(css=".errorList>li")
    private WebElement error;

    @FindBy(name="Continue")
    private WebElement buttonContinue;

    public void clickRadioButtonCars() {
        new Actions(driver).moveToElement(radioButtonCars).click().build().perform();
    }
    public void clickCheckBoxReturning() {
        if(!checkBoxReturning.isSelected()) {
            new Actions(driver).moveToElement(checkBoxReturning).click().build().perform();
        }
    }
    public boolean divForNameLocationIsDisabled(){
        return divForNameLocation.isDisplayed();
    }
    public void clickButtonContinue(){
        buttonContinue.click();
    }
    public String getError() {
        return error.getText();
    }
}
