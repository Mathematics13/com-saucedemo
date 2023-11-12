package homework_week10;

/** Project-4 - ProjectName : com-saucedemo
 BaseUrl = https://www.saucedemo.com/
 1. Setup chrome browser.
 2. Open URL.
 3. Print the title of the page.
 4. Print the current url.
 5. Print the page source.
 6. Enter the email to email field.
 7. Enter the password to password field.
 8. Click on Login Button.
 9. Print the current url.
 10. Navigate to baseUrl
 11. Refresh the page.
 12. Close the browser.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

public class SauceDemo
{
    static String  baseUrl = "https://www.saucedemo.com/";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException
    {
        System.setProperty("webdriver.edge.driver" ,  "msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get( baseUrl);
        Thread.sleep(4000);

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        Thread.sleep(4000);

        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys("secret_sauce");
        Thread.sleep(4000);

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
        Thread.sleep(4000);

        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.saucedemo.com/");

        driver.navigate().refresh();

        driver.quit();
    }
}
