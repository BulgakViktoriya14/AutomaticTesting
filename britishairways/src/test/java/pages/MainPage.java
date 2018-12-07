package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainPage {
    private WebDriver driver;
    @FindBy(css = ".autoWrapper>input")
    private WebElement inputTo;
    @FindBy(id = "planTripHotelDestination")
    private WebElement inputDestination;
    @FindBy(id = "journeyTypeOWflights")
    private WebElement radioButtonOneWay;
    @FindBy(css = ".styledSelect>#ad")
    private WebElement inputAdults;
    @FindBy(css = ".styledSelect>#ya")
    private WebElement inputTeens;
    @FindBy(css = ".styledSelect>#ch")
    private WebElement inputChildren;
    @FindBy(css = ".styledSelect>#inf")
    private WebElement inputInfants;
    @FindBy(css = "#flightSearchButton")
    private WebElement butSearch;
    @FindBy(id = "hotelSearchButtonHS")
    private WebElement butSearchHotels;
    @FindBy(css=".errorList>li")
    private WebElement error;
    @FindBy(name="Continue")
    private WebElement butCon;
    @FindBy(id = "retDate")
    private WebElement inputReturnDate;
    @FindBy(id = "depDate")
    private WebElement inputDepDate;
    @FindBy(id = "checkInGO")
    private WebElement inputCheckIn;
    @FindBy(id = "checkOutGO")
    private WebElement inputCheckOut;
    @FindBy(id = "carRadioSelector")
    private WebElement radioButtonCars;
    @FindBy(id = "hotelRadioSelector")
    private WebElement radioButtonHotels;
    @FindBy(id = "carOneWayRentalConfirm")
    private WebElement checkBoxReturning;
    @FindBy(id = "returningToDifferentLocation")
    private WebElement divForNameLocation;
    @FindBy(id = "adultsRoom1H")
    private WebElement inputAdultsInRoom;
    @FindBy(id = "infantsRoom1H")
    private WebElement inputInfantsInRoom;
    @FindBy(id = "childrenRoom1H")
    private WebElement inputChildrenInRoom;
    @FindBy(id = "numNightsGO")
    private WebElement countNights;
    @FindBy(css = "#depDate_table>tbody")
    private WebElement tableDep;
    @FindBy(css = "#retDate_table>tbody")
    private WebElement tableRet;
    @FindBy(css = "#checkInGO_table>tbody")
    private WebElement tableCheckIn;
    @FindBy(css = "#checkOutGO_table>tbody")
    private WebElement tableCheckOut;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public  void clearInputTo(){
        inputTo.clear();
    }
    public void setInputTo(String place) {
        inputTo.sendKeys(place);
    }
    public void setInputDestination(String place) {
        inputDestination.sendKeys(place);
    }
    public void setInputAdults(String number) {
        new Select(inputAdults).selectByValue(number);
    }
    public void setInputTeens(String number) {
        new Select(inputTeens).selectByValue(number);
    }

    public void setInputChildren(String number) {
        new Select(inputChildren).selectByValue(number);
    }
    public void setInputInfants(String number) {
        new Select(inputInfants).selectByValue(number);
    }
    public void setInputAdultsInRoom(String number) {
        new Select(inputAdultsInRoom).selectByValue(number);
    }
    public void setInputChildrenInRoom(String number) {
        new Select(inputChildrenInRoom).selectByValue(number);
    }
    public int foundCountInputInfantsInRoom() {
        List<WebElement> list = new Select(inputInfantsInRoom).getOptions();
        return list.size();
    }
    public void clickButtonSearch() {
        butSearch.click();
    }
    public void clickButtonSearchHotels() {
        butSearchHotels.click();
    }
    public void clickRadioButtonOneWay() {
        new Actions(driver).moveToElement(radioButtonOneWay).click().build().perform();
    }
    public void clickInputReturnDate(){
        inputReturnDate.click();
    }
    public void clickInputDepDate(){
        inputDepDate.click();
    }
    public void clickInputCheckIn(){
        inputCheckIn.click();
    }
    public void clickInputCheckOut(){
        inputCheckOut.click();
    }
    public void clickRadioButtonCars() {
        new Actions(driver).moveToElement(radioButtonCars).click().build().perform();
    }
    public void clickRadioButtonHotels() {
        new Actions(driver).moveToElement(radioButtonHotels).click().build().perform();
    }
    public void clickCheckBoxReturning() {
        if(!checkBoxReturning.isSelected()) {
            new Actions(driver).moveToElement(checkBoxReturning).click().build().perform();
        }
    }
    public void clickDateReturn(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        List<WebElement> arrayRet=tableRet.findElements(By.cssSelector("td>div"));
        for(WebElement cell : arrayRet) {
            if(cell.getAttribute("aria-label").equals(dateFormat.format(today))) {
                cell.click();
                break;
            }
        }
    }
    public void clickDateDep(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        Date afterTomorrow = calendar.getTime();
        List<WebElement> arrayDep=tableDep.findElements(By.cssSelector("td>div"));
        for(WebElement cell : arrayDep) {
            if(cell.getAttribute("aria-label").equals(dateFormat.format(afterTomorrow))) {
                cell.click();
                break;
            }
        }
    }
    public void clickDateCheckIn(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();
        List<WebElement> arrayCheckIn=tableCheckIn.findElements(By.cssSelector("td>div"));
        for(WebElement cell : arrayCheckIn) {
            if(cell.getAttribute("aria-label").equals(dateFormat.format(today))) {
                cell.click();
                break;
            }
        }
    }
    public void clickDateCheckOut(int count){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, count);
        Date afterTomorrow = calendar.getTime();
        List<WebElement> arrayCheckOut=tableCheckOut.findElements(By.cssSelector("td>div"));
        for(WebElement cell : arrayCheckOut) {
            if(cell.getAttribute("aria-label").equals(dateFormat.format(afterTomorrow))) {
                cell.click();
                break;
            }
        }
    }
    public void clickButCon(){
        butCon.click();
    }
    public boolean inputReturnDateIsEnabled(){
        return inputReturnDate.isEnabled();
    }
    public boolean divForNameLocationIsDisabled(){
        return divForNameLocation.isDisplayed();
    }
    public String getCountNights(){
        return countNights.getAttribute("value");
    }
    public String getDateDep(){
        return inputDepDate.getText();
    }
    public String getDateReturn(){
        return inputReturnDate.getText();
    }
    public String getError() {
        return error.getText();
    }
}
