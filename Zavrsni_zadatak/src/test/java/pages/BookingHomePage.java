package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sun.security.mscapi.CPublicKey;

import java.sql.SQLOutput;
import java.util.List;

public class BookingHomePage extends BasePage {

    public BookingHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".ce45093752")
    WebElement destinationInput;
    @FindBy(css = ".d47738b911:nth-child(2)")
    WebElement calendar;
    @FindBy(xpath = "//*[@id='calendar-searchboxdatepicker']/div/div[1]/div/div[1]/table/tbody/tr[5]/td[2]")
    WebElement checkInDate; // 25.07.
    @FindBy(xpath = "//*[@id='calendar-searchboxdatepicker']/div/div[1]/div/div[2]/table/tbody/tr[1]/td[3]")
    WebElement checkOutDate; // 02.08.
    @FindBy(css = ".d67edddcf0")
    WebElement passengerInput;
    @FindBy(css = ".ffa9856b86> :nth-child(4) > .fc63351294")
    WebElement searchButton;
    @FindBy(css = ".ae1678b153 svg")
    WebElement popup;
    @FindBy(xpath = "//*[@id='right']/div[1]/div/div/h1")
    WebElement searchResultsPage;


//   Ostali selektori za selectCheckInDate:
//
//    @FindBy(xpath = "//*[@id='calendar-searchboxdatepicker']/div/div[1]/div/div[1]/table/tbody")
//    List <WebElement> checkInDateGrid;
//    @FindBy(xpath = "//*[@id=calendar-searchboxdatepicker]/div/div[1]/div/div[1]/h3")
//    WebElement monthYear;
//    @FindBy (xpath = "//*[@id='calendar-searchboxdatepicker']/div/div[1]/button[2]")
//    WebElement nextArrow;


    public void dismissPopup() {
        popupModal(popup, "Popup is dismissed!");
    }

    public void enterDestination(String destination) throws Exception {
        typeText(destinationInput, destination, "Destination " + destination + " is typed in destination field.");
    }

//    Odlucila sam se da zakucam datume kroz selektore:
    public void selectDate() throws Exception {
        click(calendar, "Calendar field.");
        click(checkInDate, "Check in date."); // 25.07.
        click(checkOutDate, "Check out date."); // 02.08.
    }

//    Popunjen konstruktor onog neuspesnog pokusaja odabira meseca, godine i check in datuma:
//
//    public void selectCheckInDate (String checkInMonthYear, String checkInDate ){
//        selectDate(calendar, monthYear, checkInMonthYear, checkInDate, nextArrow, checkInDateGrid, "Check in date selected.");
//    }

    //    Ovde sam vec odustala i ostavila odabir broja putnika i soba po defaultu, samo sam kliknula na polje:
    public void selectPax() throws Exception {
        click(passengerInput, "Passenger and Room field.");
    }

    public void clickSearchButton() throws Exception {
        click(searchButton, "Search button.");
    }

    public void verifySearchResultsPage() {
        Assert.assertTrue(searchResultsPage.isDisplayed());
        System.out.println(searchResultsPage.getText());
    }
}







