//  Sauce Demo vezba - kupovina:
//  1. Homepage - loginuj se
//  2. "Products" strana - klik na "Add to cart" (bilo koji proizvod)
//  3. "Products" strana - klik na cart ikonicu
//  4. "Your Cart" strana - klik na "Checkout"
//  5. "Checkout: Your Information" strana - popuni detalje i klik na "Continue"
//  6. "Checkout: Overview" strana - klik na "Finish" dugme
//  7. "Checkout: Complete!" strana - klik na "Back Home" dugme

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sauce {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver11490.exe");

        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://www.saucedemo.com/");
        browser.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        browser.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        Thread.sleep(2000);
        browser.findElement(By.cssSelector("#login-button")).click();
        browser.findElement(By.cssSelector(".inventory_list>div:nth-child(2) button")).click();
        browser.findElement(By.cssSelector(".shopping_cart_link")).click();
        Thread.sleep(2000);
        browser.findElement(By.cssSelector("#checkout")).click();
        browser.findElement(By.cssSelector("#first-name")).sendKeys("Svetlana");
        browser.findElement(By.cssSelector("#last-name")).sendKeys("Kasic");
        browser.findElement(By.cssSelector("#postal-code")).sendKeys("12345");
        Thread.sleep(2000);
        browser.findElement(By.cssSelector("#continue")).click();
        Thread.sleep(2000);
        browser.findElement(By.cssSelector("#finish")).click();
        Thread.sleep(2000);
        browser.findElement(By.cssSelector("#back-to-products")).click();
        Thread.sleep(2000);
        browser.quit();
    }
}


