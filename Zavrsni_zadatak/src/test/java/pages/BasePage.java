package pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.BaseTest;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;


public class BasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    int maxRetries = 4;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentTimeDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public void assertEQ(String actual, String expected, String log) {
        Assert.assertEquals(actual, expected);
        System.out.println(getCurrentTimeDate() + "Verified " + log);
    }

    BaseTest baseTest = new BaseTest();

    public void popupModal(WebElement element, String log) {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(driver);
        actions.moveByOffset(100, 100).click().perform();
        System.out.println(getCurrentTimeDate() + " Clicked anywhere on the page. " + log);
    }

    public void click(WebElement element, String log) throws Exception {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));


        int retryCount = 0;
        while (retryCount < maxRetries) {
            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(element));
                webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                System.out.println(getCurrentTimeDate() + " Clicked: " + log);
                break;
            } catch (Exception e) {
                retryCount++;
                System.out.println("Retry " + retryCount + " to click on " + log);
                if (retryCount == maxRetries) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                    baseTest.reportScreenshot("failedClick", "Failed to click");
                    throw new Exception(getCurrentTimeDate() + " Failed to click element: " + log);
                }
            }
        }
    }

    public void typeText(WebElement element, String text, String log) throws Exception {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));


        int retryCount = 0;
        while (retryCount < maxRetries) {
            try {
                webDriverWait.until(ExpectedConditions.visibilityOf(element));
                element.sendKeys(text);
                System.out.println(getCurrentTimeDate() + " Typed: " + text + " - " + log);
                break;
            } catch (Exception fail) {
                retryCount++;
                System.out.println("Retry " + retryCount + " to type to " + log);
                if (retryCount == maxRetries) {
                    fail.printStackTrace();
                    System.out.println(fail.getMessage());
                    baseTest.reportScreenshot("failedTypeText", "Failed to type");
                    throw new Exception(getCurrentTimeDate() + " Failed to type to element: " + log);
                }
            }
        }
    }

}



// Neuspesan pokusaj univerzalne metode za odabir meseca i godine, check in i check out datuma:
//
//    public void selectDate (WebElement _calendar, WebElement _monthYear, String _checkInMonthYear, String _date, WebElement _nextArrow, List<WebElement> _dateGrid, String log){
//        _calendar.click();
//        while(!_monthYear.getText().contains(_checkInMonthYear)){
//            _nextArrow.click();
//            System.out.println("Clicked next arrow. Searching for date.");
//        }
//
//        int count = _dateGrid.size();
//        for (int i=0; i<count; i++){
//            String text=_dateGrid.get(i).getText();
//            String[] arrOfStr =  text.split("\n");
//            System.out.println("text is "+ Arrays.toString(arrOfStr));/
//
//            if(text.equals(_date)){
//                _dateGrid.get(i).click();
//                break;
//            }
//        }
//    }
//}














