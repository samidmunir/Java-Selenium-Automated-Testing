package hooks;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;
import utils.ProcessConfig;

public class DriverHooks {
    @Before
    public void init() {
        String browser = ProcessConfig.getProperty("browser");
        WebDriver driver = DriverFactory.initializeDriver(browser);
        DriverManager.setDriver(driver);

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}