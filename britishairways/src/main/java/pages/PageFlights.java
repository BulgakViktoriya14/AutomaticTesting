package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PageFlights extends MainPage {
    @FindBy(css = ".autoWrapper>input")
    private WebElement inputTo;

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

    @FindBy(id = "retDate")
    private WebElement inputReturnDate;

    @FindBy(id = "depDate")
    private WebElement inputDepDate;

    @FindBy(css = "#depDate_table>tbody")
    private WebElement tableDep;

    @FindBy(css = "#retDate_table>tbody")
    private WebElement tableRet;

    @FindBy(css=".errorList>li")
    private WebElement error;

    @FindBy(name="Continue")
    private WebElement buttonContinue;

    public  void clearInputTo(){
        inputTo.clear();
    }
    public void setInputTo(String place) {
        inputTo.sendKeys(place);
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
    public void clickRadioButtonOneWay() {
        new Actions(driver).moveToElement(radioButtonOneWay).click().build().perform();
    }
    public void clickInputReturnDate(){
        inputReturnDate.click();
    }
    public void clickInputDepDate(){
        inputDepDate.click();
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
    public void clickDateDep(int count){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, count);
        Date afterTomorrow = calendar.getTime();
        List<WebElement> arrayDep=tableDep.findElements(By.cssSelector("td>div"));
        for(WebElement cell : arrayDep) {
            if(cell.getAttribute("aria-label").equals(dateFormat.format(afterTomorrow))) {
                cell.click();
                break;
            }
        }
    }
    public boolean inputReturnDateIsEnabled(){
        return inputReturnDate.isEnabled();
    }
    public String getDateDep(){
        return inputDepDate.getText();
    }
    public String getDateReturn(){
        return inputReturnDate.getText();
    }
    public void clickButtonSearch() {
        butSearch.click();
    }
    public void clickButtonContinue(){
        buttonContinue.click();
    }
    public String getError() {
        return error.getText();
    }
}
