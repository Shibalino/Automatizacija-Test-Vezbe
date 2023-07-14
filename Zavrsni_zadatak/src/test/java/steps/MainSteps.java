package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages.BookingHomePage;
import tests.BaseTest;

import java.util.Map;

public class MainSteps extends BaseTest {
    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");
    String quit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("quit");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
//    Map<String, String> data;

    @Before
    public void setup() throws Exception {
        init(browser, wait);
    }

    @After
    public void tearDown() {
        if (quit.equalsIgnoreCase("YES")) {
            quit();
        }

    }

    @Given("user is on the booking home page")
    public void userIsOnTheBookingHomePage() {
        driver.get("https://www.booking.com/");
    }

    @When("user dismisses popup")
    public void userDismissesPopup() {
        new BookingHomePage(driver).dismissPopup();
    }

    @And("user enters destination {string}")
    public void userEntersDestination(String destination) throws Exception {
        new BookingHomePage(driver).enterDestination(destination);
    }

    @And("user selects travel dates")
    public void userSelectsTravelDates() throws Exception {
        new BookingHomePage(driver).selectDate();
    }

//  Koraci za odabir check in i check out datuma koji bi koristli onu neuspesnu metodu selectDate.
//
//    @And("user selects check in date {string}, [string]")
//    public void userSelectsCheckInDate(String checkInMonthYear, String checkInDate) throws Exception {
//        new BookingHomePage(driver).setDateIn(checkInMonthYear, checkInDate);
//    }
//
//    @And("user selects check out date {string}, [string]")
//    public void userSelectsCheckInDate(String checkOutMonthYear, String checkOutDate) throws Exception {
//        new BookingHomePage(driver).setDateIn(checkOutMonthYear, checkOutDate);
//    }


    @And("user clicks passenger field leaving everything by default")
    public void userClicksPassengerFieldLeavingEverythingByDefault() throws Exception {
        new BookingHomePage(driver).selectPax();
    }

    @And("user clicks on the search button")
    public void userClicksOnTheSearchButton() throws Exception {
        new BookingHomePage(driver).clickSearchButton();
    }


    @Then("user is redirected to the search results page")
    public void userIsRedirectedToTheSearchResultsPage() {
        new BookingHomePage(driver).verifySearchResultsPage();
    }
}



