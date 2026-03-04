package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); // every window & quits the driver
        // driver.close(); // only closes the current window
    }

    @Test
    public void testLogin() throws InterruptedException {
        /*
            Pause the execution for slower UI testing...
        */
        Thread.sleep(3000);

        /*
            Capture web elements
        */
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.tagName("button"));

        /*
            Send data to inputs using sendKeys()
        */
        Thread.sleep(2000);
        usernameInput.sendKeys("Admin");
        Thread.sleep(2000);
        passwordInput.sendKeys("admin123");

        /*
            Perform click action on login button
        */
        Thread.sleep(2000);
        loginButton.click();

        /*
            Pause the execution for slower UI testing...
        */
        Thread.sleep(2000);

        /*
            Assert successful login by comparing heading/title of dashboard page with the string "Dashboard".
        */
        String actualTitle = driver.findElement(By.tagName("h6")).getText();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

        Thread.sleep(2000);
    }
}