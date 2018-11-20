package pages;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public WebDriver driver;
    @FindBy(css = ".autoWrapper>input")
    private WebElement inputTo;
    @FindBy(css = ".styledRadioButton>span")
    private WebElement checkBoxOneWay;
    @FindBy(css = ".styledSelect>#ad")
    private WebElement inputAdults;
    @FindBy(css = ".styledSelect>#ya")
    private WebElement inputTeens;
    @FindBy(css = ".styledSelect>#ch")
    private WebElement inputChildren;
    @FindBy(css = "#flightSearchButton")
    private WebElement butSearch;
    @FindBy(css=".errorList>li")
    private WebElement error;
    @FindBy(name = "Continue")
    private WebElement butCon;

    public void setInputTo(String place) {
        inputTo.clear();
        inputTo.sendKeys(place);
    }

    public void setInputAdults() {
        new Select(inputAdults).selectByValue("5");
    }

    public void setInputTeens() {
        new Select(inputTeens).selectByValue("4");
    }

    public void setInputChildren() {
        new Select(inputChildren).selectByValue("3");
    }

    public void clickSearchButton() {
        butSearch.click();
    }

    public void clickContinueButton() {
        butCon.click();
    }

    public void clickCheckBoxOneWay() {
        new Actions(driver).moveToElement(checkBoxOneWay).click().build().perform();
    }
    public String getError() {
        return error.getText();
    }
}
