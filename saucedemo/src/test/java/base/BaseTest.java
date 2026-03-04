package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.pages.BasePage;
import com.pages.LoginPage;

public class BaseTest {
    protected WebDriver driver;
    protected BasePage basePage;
    private String BASE_URL = "https://www.saucedemo.com/";

    protected LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        
        basePage = new BasePage();
        basePage.setDriver(driver);

        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}